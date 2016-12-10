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
        <%--        <div class="page-header">
                    <h1>新增请假单</h1>
                </div>--%>
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
                                <h4 class="widget-title">新增流程定义</h4>

                                    <%--                              <div class="widget-toolbar">
                                                                      <a href="${ctx}/hcolony/add" class="btn btn-primary btn-xs" title="新增请假单"
                                                                         data-toggle="tooltip">
                                                                          <i class="ace-icon fa bigger-125 fa-plus"></i>
                                                                      </a>
                                                                  </div>--%>
                            </div>

                            <div class="widget-body">
                                <form class="form-horizontal" action="${ctx}/act/process/add" method="post"
                                      enctype="multipart/form-data" id="registerForm">

                                    <div class="form-group" id="div1">
                                        <div class="space-4"></div>
                                        <label class="col-sm-4 control-label no-padding-right"> 流程名称
                                            <small style="color: red">*</small>
                                        </label>

                                        <div class="col-sm-7">
                                            <input type="text" placeholder="" class="col-xs-7" name="processName" required
                                                   data-bv-notempty-message="表名不可为空" maxlength="50"/>
                                        </div>
                                        <div class="space-4"></div>
                                    </div>

                                    <div class="form-group" id="div9">
                                        <label class="col-sm-4 control-label no-padding-right"> 流程文件
                                            <small style="color: red">*</small>
                                        </label>

                                        <div class="ace-file-input col-sm-7" id="fileInput">
                                            <input type="file" id="id-input-file-1" name="file" required
                                                   data-bv-notempty-message="配置文件不可为空"/>
                                            <small id="small1" style="display:none" class="help-block"
                                                   data-bv-result="INVALID">&nbsp;&nbsp;只能上传zip类型文件！
                                            </small>
                                        </div>
                                        <div class="space-4"></div>
                                    </div>


                                    <div class="form-actions center">
                                        <button class="btn btn-primary" type="submit" id="bt1">
                                            提交
                                            <i class="icon-arrow-right icon-on-right bigger-110"></i>
                                        </button>
                                        <button class="btn btn-primary" type="reset"
                                                onclick="javascript:history.back()">
                                            返回
                                            <i class="icon-arrow-right icon-on-right bigger-110"></i>
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>

                    </div>
                </div>
                    <%--/.页面正文--%>

                <!-- PAGE CONTENT BEGINS END-->
            </div>
        </div>

        <script>
            $(function () {
                <c:if test="${not empty error}">
                $.scojs_message("${error}", $.scojs_message.TYPE_ERROR);
                </c:if>
                <c:if test="${not empty success}">
                $.scojs_message("${success}", $.scojs_message.TYPE_OK);
                </c:if>

                $('#id-input-file-1').ace_file_input({
                    no_file: '未选择上传文件 ...',
                    btn_choose: '选择上传文件',
                    btn_change: 'Change',
                    droppable: false,
                    onchange: null,
                    thumbnail: false,//| true | large
                    whitelist: 'zip',
                    blacklist: 'exe|php'
                    //onchange:''
                    //
                }).on('change', function () {
                    var inputFile = $('#id-input-file-1').val().toLowerCase();
                    if (inputFile.match(/.zip$/) != '.zip') {//java
                        $('#small1').show();//显示提示消息
                        //显示错误图标
                        $('#fileInput').find("i").removeClass('glyphicon-ok');
                        $('#fileInput').find("i").addClass('glyphicon-remove');
                        //设置错误字体
                        $("#div9").addClass("has-error");
                        //设置表单为不可提交状态
                        $("#bt1").attr('disabled', 'disabled');
                    } else {
                        $("#div9").removeClass("has-error").addClass("has-success");
                        $("#fileInput > .form-control-feedback").show();
                        $("#fileInput > .form-control-feedback").removeClass("glyphicon-remove");
                        $("#fileInput > .form-control-feedback").addClass("glyphicon glyphicon-ok");
                        $("#bt1").removeAttr("disabled");
                        $('#small1').hide();
                    }

                });
                $($("#fileInput").find("label")[0]).addClass("col-xs-7");


            });
        </script>
    </jsp:body>
</t:base_layout>
