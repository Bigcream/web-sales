<%-- 
    Document   : List
    Created on : Feb 27, 2022, 12:48:17 PM
    Author     : ASUS
--%>
<%@include file="/Comons/taglib.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url var="APIurl" value="/api-admin-product"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List order</title>
    </head>
    <body>
        <div class="main-content">
            <form action="<c:url value='/Admin-Order'/>" id="formSubmit" method="get">
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

                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <div class="table-responsive">
                                                <table class="table table-bordered">
                                                    <thead>
                                                        <tr>
                                                            <th>Name</th>
                                                            <th>Quantity</th>
                                                            <th>Total Price</th>
                                                            <th>Status</th>
                                                            <th>Edit</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="item" items="${model.listResult}">
                                                            <tr>
                                                                <td>${item.product_Name}</td>
                                                                <td>${item.product_Quantity}</td>
                                                                <td>${item.product_Price}</td>
                                                                <td>
                                                                    <select id="idS" name="idS" >
                                                                        <c:forEach var="items" items="${status}">
                                                                            <option value='${items.idS}'>${items.status}</option>
                                                                        </c:forEach>
                                                                        <c:url var="editURL" value="/Admin-Order">
                                                                            <c:param name="page" value="${oldPage}"/>
                                                                            <c:param name="type" value="list"/>
                                                                            <c:param name="idS" value="${items.idS}"/>
                                                                            <c:param name="id" value="${item.id}"/>
                                                                        </c:url>
                                                                    </select>
                                                                </td>
                                                                <td>
                                                                    <button id="btnUpdate" type="button"
                                                                            class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Delete product'>
                                                                        <span>
                                                                            <i class="fa fa-trash-o bigger-110 pink"></i>
                                                                        </span>
                                                                    </button>
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
            $("#btnUpdate").click(function () {
                var data = {};
                var e = ${items.idS};
                var id = ${item.id};
                data["id"] = id;
                data["idS"] = idS;
                if (idS != null && idS.length != 0) {
                    data["ids"] = ids;
                    deleteProduct(data);
                } else {
                    deleteError(data);
                }

            });
            function deleteProduct(data) {
                $.ajax({
                    url: '${APIurl}',
                    type: 'UPDATE',
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
