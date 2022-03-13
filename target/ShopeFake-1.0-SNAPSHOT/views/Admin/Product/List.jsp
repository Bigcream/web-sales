<%-- 
    Document   : List
    Created on : Feb 7, 2022, 11:44:03 PM
    Author     : ASUS
--%>
<%@include file="/Comons/taglib.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url var="APIurl" value="/api-admin-product"/>
<c:url var ="ProductURL" value="/Admin-Product"/>
<c:url var="productURL" value="/Admin-Product">
    <c:param name="type" value="list"/>
    <c:param name="page" value="${model.page }"/>
</c:url>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List product</title>
    </head>
    <body>
        <div class="main-content">
            <form action="<c:url value='/Admin-Product'/>" id="formSubmit" method="get">
                <div class="main-content-inner">
                    <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                        <ul class="breadcrumb">
                            <li>
                                <i class="ace-icon fa fa-home home-icon"></i>
                                <a href="<c:url value="/AdminHome"/>">Home</a>
                            </li>
                        </ul><!-- /.breadcrumb -->
                    </div>
                    <div class="page-content">
                        <div class="row" >
                            <div class="col-xs-12">
                                <c:if test="${not empty messageResponse}">
                                    <div class="alert alert-${alert}">
                                        ${messageResponse}
                                    </div>
                                </c:if>
                                <div class="widget-box table-filter">
                                    <div class="table-btn-controls">
                                        <div class="pull-right tableTools-container">
                                            <div class="dt-buttons btn-overlap btn-group">
                                                <a flag="info"
                                                   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
                                                   title='Add new product' href='<c:url value="/Admin-Product?type=edit"/>'>
                                                    <span>
                                                        <i class="fa fa-plus-circle bigger-110 purple"></i>
                                                    </span>
                                                </a>
                                                <button id="btnDelete" type="button"
                                                        class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Delete product'>
                                                    <span>
                                                        <i class="fa fa-trash-o bigger-110 pink"></i>
                                                    </span>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <div class="table-responsive">
                                                <table class="table table-bordered">
                                                    <thead>
                                                        <tr>
                                                            <th><input type="checkbox" id="checkAll"></th>
                                                            <th>Name</th>
                                                            <th>Image</th>
                                                            <th>Price</th>
                                                            <th>Short description</th>
                                                            <th>Edit</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="item" items="${model.listResult}">
                                                            <tr>
                                                                <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
                                                                <td>${item.name}</td>
                                                                <td scope="row"><img alt="" src="${item.image_Link}" style="width: 50px;height: 50px;"></td>
                                                                <td>${item.price}</td>
                                                                <td>${item.description}</td>
                                                                <td>
                                                                    <c:url var="editURL" value="/Admin-Product">
                                                                        <c:param name="type" value="edit"/>
                                                                        <c:param name="id" value="${item.id}"/>
                                                                        <c:param name="name" value="${item.name}"/>
                                                                    </c:url>
                                                                    <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                                       title="Edit product" href='${editURL}'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                                    </a>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                                <ul class="pagination" id="pagination" style="float: right"></ul>
                                                <input type="hidden" value="" id="page" name="page"/>
                                                <input type="hidden" value="" id="type" name="type"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
            </form>
        </div><!-- /.main-content -->
        <script type="text/javascript">
            var currenPage = ${model.page};
            var totalPages = ${model.totalPage};
            var visiblePages = ${model.maxPageItem};
            var limit = 2;
            $(function () {
                window.pagObj = $('#pagination').twbsPagination({
                    totalPages: totalPages,
                    visiblePages: limit,
                    startPage: currenPage,
                    onPageClick: function (event, page) {
                        if (currenPage != page) {
                            $('#page').val(page);
                            $('#type').val('list');
                            $('#formSubmit').submit();
                        }
                    }
                });
            });
            $("#btnDelete").click(function () {
                var data = {};
                var ids = $('tbody input[type=checkbox]:checked').map(function () {
                    return $(this).val();
                }).get();
                if (ids != null && ids.length != 0) {
                    data["ids"] = ids;
                    deleteProduct(data);
                } else {
                    deleteError(data);
                }

            });
            function deleteProduct(data) {
                $.ajax({
                    url: '${APIurl}',
                    type: 'DELETE',
                    contentType: 'application/json',
                    data: JSON.stringify(data),
                    success: function (result) {
                        window.location.href = "${productURL}" + "&message=delete_success";
                    },
                    error: function (error) {
                        window.location.href = "${productURL}" + "&message=error_system";
                    }
                });
            }
            function deleteError(data) {
                $.ajax({
                    url: '${APIurl}',
                    type: 'DELETE',
                    contentType: 'application/json',
                    data: JSON.stringify(data),
                    success: function (result) {
                        window.location.href = "${productURL}" + "&message=error_system";
                    },
                    error: function (error) {
                        window.location.href = "${productURL}" + "&message=error_system";
                    }
                });
            }
        </script>
    </body>
</html>
