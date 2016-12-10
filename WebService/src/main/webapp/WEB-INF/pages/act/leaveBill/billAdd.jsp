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
                                <h4 class="widget-title">新增请假单</h4>
                            </div>

                            <div class="widget-body">
                                <form class="form-horizontal" action="${ctx}/act/leaveBill/add" method="post">
                                    <div class="space-4"></div>
                                    <div class="form-group" id="div1">
                                        <label class="col-sm-4 control-label no-padding-right"> 请假理由
                                            <small style="color: red">*</small>
                                        </label>

                                        <div class="col-sm-7">
                                            <input type="text" placeholder="" class="col-xs-7" name="content" required
                                                   data-bv-notempty-message="表名不可为空" maxlength="50"/>
                                        </div>
                                    </div>

                                    <div class="form-group" id="div2">
                                        <label class="col-sm-4 control-label no-padding-right"> 天数
                                            <small style="color: red">*</small>
                                        </label>

                                        <div class="col-sm-7">
                                            <input type="text" placeholder="" class="col-xs-7" name="days" required
                                                   data-bv-notempty-message="表名不可为空" maxlength="20"/>
                                        </div>
                                    </div>

                                    <div class="form-group" id="div3">
                                        <div class="space-4"></div>
                                        <label class="col-sm-4 control-label no-padding-right">请假时间
                                            <small style="color: red">*</small>
                                        </label>

                                        <div class="col-sm-7">
                                            <div class="input-group col-sm-7">
                                                <input class="form-control date-picker" id="id-date-picker-1"
                                                       type="text" name="leaveDate"
                                                       data-date-format="yyyy-mm-dd"/>
																	<span class="input-group-addon">
																		<i class="fa fa-calendar bigger-110"></i>
																	</span>
                                            </div>
                                        </div>

                                            <%-- <div class="col-xs-7 col-sm-7">
                                             <div class="col-sm-7">
                                                 <input class="date-picker col-xs-7" required name="leaveDate"
                                                        type="text" data-date-format="yyyy-mm-dd"/>
                                                 <span>
                                                     <i class="fa fa-calendar bigger-110"></i>
                                                 </span>
                                             </div>
                                                 </div>--%>
                                    </div>

                                    <div class="form-group" id="div4">
                                        <label class="col-sm-4 control-label no-padding-right"> 天数
                                            <small style="color: red">*</small>
                                        </label>

                                        <div class="col-sm-7">
                                            <textarea class="col-xs-7" placeholder="Default Text"
                                                      required name="remark"></textarea>
                                        </div>
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
        <script src="${ctx}/component/ace/assets/js/jquery.dataTables.min.js"></script>
        <script src="${ctx}/component/ace/assets/js/jquery.dataTables.bootstrap.min.js"></script>
        <script src="${ctx}/js/zh_CN.js"></script>

        <script src="${ctx}/component/ace/assets/js/date-time/bootstrap-datepicker.min.js"></script>
        <link rel="stylesheet" href="${ctx}/component/ace/assets/css/datepicker.css"/>
        <script>
            $(function () {
                <c:if test="${not empty error}">
                $.scojs_message("${error}", $.scojs_message.TYPE_ERROR);
                </c:if>
                <c:if test="${not empty success}">
                $.scojs_message("${success}", $.scojs_message.TYPE_OK);
                </c:if>
            });


            $('.date-picker').datepicker({autoclose: true}).next().on(ace.click_event, function () {
                $(this).prev().focus();
            });
        </script>
    </jsp:body>
</t:base_layout>
