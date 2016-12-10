<%--
  Created by IntelliJ IDEA.
  User: home
  Date: 2016/7/21
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<t:base_layout>
    <jsp:attribute name="title">
       流程定义管理
    </jsp:attribute>
    <jsp:body>
        <div class="page-header">
            <h1>流程定义管理</h1>
        </div>
        <!-- /.page-header -->


        <div class="row">
            <div class="col-xs-12">

                <!-- PAGE CONTENT BEGINS START-->
                <div class="row">
                    <div class="col-xs-12">
                        <div class="space-6"></div>
                    </div>
                </div>

                    <%--页面正文--%>
                <div class="row">
                    <div class="col-xs-12 widget-container-col ui-sortable">

                            <%--表1--%>
                        <div class="widget-box widget-color-blue2 ui-sortable-handle">
                            <div class="widget-header">
                                <h4 class="widget-title">流程定义列表</h4>

                                <div class="widget-toolbar">
                                    <a href="${ctx}/act/process/add" class="btn btn-primary btn-xs" title="新增流程定义"
                                       data-toggle="tooltip">
                                        <i class="ace-icon fa bigger-125 fa-plus"></i>
                                    </a>
                                </div>
                            </div>

                            <div class="widget-body">
                                <table class="table table-striped table-bordered table-hover" id="table">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>名称</th>
                                        <th>KEY</th>
                                        <th>版本</th>
                                        <th>部署ID</th>
                                        <th>文件资源名称</th>
                                        <th>图表资源名称</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${ProcessDefines}" var="pds">
                                        <tr>

                                            <td>${pds.id}</td>
                                            <td>${pds.name}</td>
                                            <td>${pds.key}</td>
                                            <td>${pds.version}</td>
                                            <td>${pds.deploymentId}</td>
                                            <td>${pds.resourceName}</td>
                                            <td>${pds.diagramResourceName}</td>
                                            <td>
                                                <a href="javascript" data-toggle="modal"
                                                   onclick="startProcess('${pds.key}')"
                                                   class="btn btn-info btn-sm">启动</a>
                                                <a target="_blank" href="${ctx}/act/process/view?deploymentId=${pds.deploymentId}&resourceName=${pds.diagramResourceName}" data-toggle="modal"
                                                   class="btn btn-info btn-sm">查看流程图</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                    </div>
                </div>
                    <%--/.页面正文--%>

                <!-- PAGE CONTENT BEGINS END-->
            </div>
        </div>

        <div class="modal fade" id="startProcessConfirm" data-backdrop="static" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                        <h4 class="modal-title">确认</h4>
                    </div>
                    <div class="modal-body">
                        确定要启动该流程定义？
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-danger" id="startProcessSure">确定</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- 页面等待 -->
        <div class="modal fade" id="waiting" data-backdrop="static" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <p>
                            <i class="fa fa-spinner fa-pulse fa-5x fa-fw margin-bottom"></i>
                            <strong>正在加速提交中</strong>
                        </p>
                    </div>
                </div>
            </div>
        </div>

        <script src="${ctx}/component/ace/assets/js/jquery.dataTables.min.js"></script>
        <script src="${ctx}/component/ace/assets/js/jquery.dataTables.bootstrap.min.js"></script>
        <script src="${ctx}/js/zh_CN.js"></script>

        <script>
            $(function () {

                <c:if test="${not empty error}">
                $.scojs_message("${error}", $.scojs_message.TYPE_ERROR);
                </c:if>
                <c:if test="${not empty success}">
                $.scojs_message("${success}", $.scojs_message.TYPE_OK);
                </c:if>

                $("#table").dataTable({
                    "autoWidth": true,
                    paging: true, //分页，false|true
                    language: language(),  //中文
                    "info": true,  //左下角信息，可以使用 language一起控制
                    lengthChange: true,//每页显示的数据量，提前是 paging 为true.
                    "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],// 每页显示的数据量
                    "processing": true,
                    "ordering": true, //排序
                    "searching": true, //搜索过滤
                });

            });

            function startProcess(processKey) {
                $('#startProcessConfirm').modal('show').on('shown.bs.modal', function () {//绑定监听事件，当模态框显示后，执行相应的动作
                    $("#startProcessSure").on("click", function () {
                        $.ajax({
                            url: "${ctx}/act/process/ajax/startProcess",
                            type: "post",
                            data: "processKey=" + processKey,
                            beforeSend: function () {
                                //这里是开始执行方法，显示效果，效果自己写
                                $('#startProcessConfirm').modal('hide');
                                $('#waiting').modal('show');
                            },
                            complete: function () {
                                //方法执行完毕，效果自己可以关闭，或者隐藏效果
                                $('#waiting').modal('hide');
                            },
                            success: function (data) {
                                //数据加载成功
                                if ("0" == data.isSuccess) {
                                    $.scojs_message('操作成功！', $.scojs_message.TYPE_OK);
                                } else {
                                    $.scojs_message(data.error, $.scojs_message.TYPE_ERROR);
                                }
                                window.setTimeout(function () {
                                    location.reload();
                                }, 1000);
                            },
                            error: function () {
                                //数据加载失败
                            }
                        });
                    });
                });
            }

        </script>
    </jsp:body>
</t:base_layout>
