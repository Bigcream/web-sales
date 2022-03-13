<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/Comons/taglib.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title><dec:title default="Admin" /></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<c:url value='/Template/Admin/assets/css/bootstrap.min.css' />" />
        <link rel="stylesheet" href="<c:url value='/Template/Admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />
        <link rel="stylesheet" href="<c:url value='/Template/Admin/assets/css/ace.min.css' />" class="ace-main-stylesheet" id="main-ace-style" />
        <script src="<c:url value='/Template/Admin/assets/js/ace-extra.min.js' />"></script>
        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script type='text/javascript' src='<c:url value="/Template/Admin/js/jquery-2.2.3.min.js" />'></script>
        <script src="<c:url value='/Template/Admin/assets/js/jquery.2.1.1.min.js' />"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="<c:url value='/Template/Paging/jquery.twbsPagination.js' />"></script>
        <script src="<c:url value='/Template/Paging/jquery.twbsPagination.min.js' />"></script>
        <script src="<c:url value='/ckeditor/ckeditor.js' />"></script>
    </head>
    <body class="no-skin">
        <!-- header -->
        <%@ include file="/Comons/Admin/AHeader.jsp" %>
        <!-- header -->
        <div class="main-container" id="main-container">
            <script type="text/javascript">
                try {
                    ace.settings.check('main-container', 'fixed')
                } catch (e) {
                }
            </script>
            <!-- header -->
            <%@ include file="/Comons/Admin/Menu.jsp" %>
            <!-- header -->

            <dec:body/>

            <!-- footer -->
            <%@ include file="/Comons/Admin/AFooter.jsp" %>
            <!-- footer -->

            <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse display">
                <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
            </a>
        </div>
        <script src="<c:url value='/Template/Admin/assets/js/bootstrap.min.js' />"></script>
        <script src="<c:url value='/Template/Admin/assets/js/jquery-ui.custom.min.js' />"></script>
        <script src="<c:url value='/Template/Admin/assets/js/jquery.ui.touch-punch.min.js' />"></script>
        <script src="<c:url value='/Template/Admin/assets/js/jquery.easypiechart.min.js' />"></script>
        <script src="<c:url value='/Template/Admin/assets/js/jquery.sparkline.min.js' />"></script>
        <script src="<c:url value='/Template/Admin/assets/js/jquery.flot.min.js' />"></script>
        <script src="<c:url value='/Template/Admin/assets/js/jquery.flot.pie.min.js' />"></script>
        <script src="<c:url value='/Template/Admin/assets/js/jquery.flot.resize.min.js' />"></script>
        <script src="<c:url value='/Template/Admin/assets/js/ace-elements.min.js' />"></script>
        <script src="<c:url value='/Template/Admin/assets/js/ace.min.js' />"></script>
        <script src="<c:url value='/Template/Admin/assets/js/bootstrap.min.js'/>"></script>

        <!-- page specific plugin scripts -->
        <script src="<c:url value='/Template/Admin/assets/js/jquery-ui.min.js'/>"></script>
        
    </body>
</html>
