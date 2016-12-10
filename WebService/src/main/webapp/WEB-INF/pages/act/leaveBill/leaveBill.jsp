<%--suppress JSUnresolvedFunction --%>
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
       请假单管理
    </jsp:attribute>
    <jsp:body>
        <div class="page-header">
            <h1>请假单管理</h1>
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
                                <h4 class="widget-title"></h4>
                                    <%--<span class="widget-toolbar">
                                        <a href="#" data-action="collapse">
                                            <i class="fa fa-angle-down" aria-hidden="true"></i>
                                        </a>
                                    </span>--%>

                                <div class="widget-toolbar">
                                    <a href="${ctx}/act/leaveBill/add" class="btn btn-primary btn-xs" title="新增请假单"
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
                                        <th>请假理由</th>
                                        <th>请假天数</th>
                                        <th>请假起始日</th>
                                        <th>备注</th>
                                        <th>状态</th>
                                        <th>请假人</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${leaveBills}" var="leaveBill">
                                        <tr>
                                            <td>${leaveBill.id}</td>
                                            <td>${leaveBill.content}</td>
                                            <td>${leaveBill.days}</td>
                                            <td><fmt:formatDate value="${leaveBill.leaveDate}" type="date"/></td>
                                            <td>${leaveBill.remark}</td>
                                            <td>${leaveBill.status}</td>
                                            <td>${leaveBill.user.username}</td>
                                            <td>
                                                <c:if test="${!(leaveBill.status eq 'APPROVE')}">
                                                    <a href="javascript" data-toggle="modal"
                                                       onclick="deleteBill('${leaveBill.id}')"
                                                       class="btn btn-danger btn-sm">删除</a>
                                                </c:if>
                                                <c:if test="${leaveBill.status eq 'INIT'}">
                                                <a href="${ctx}/act/leaveBill/startBill?billId=${leaveBill.id}" data-toggle="modal"
                                                   class="btn btn-info btn-sm">申请</a>
                                                </c:if>
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

        <div class="modal fade" id="delBillConfirm" data-backdrop="static" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                        <h4 class="modal-title">确认</h4>
                    </div>
                    <div class="modal-body">
                        确定要删除该请假条？
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-danger" id="delBillSure">确定</button>
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

                $("#table").DataTable({
                    "autoWidth": true,
                    paging: true, //分页，false|true
                    language: language(),  //中文
                    lengthChange: true,//每页显示的数据量，提前是 paging 为true.
                    "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],// 每页显示的数据量
                    "searching": true //搜索过滤
                });

            });


            function startBill(billId) {
                alert("...");
            }

        </script>
    </jsp:body>
</t:base_layout>
