<%-- 
    Document   : Edit.jsp
    Created on : Feb 16, 2022, 1:40:32 PM
    Author     : ASUS
--%>
<%@include file="/Comons/taglib.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url var="APIurl" value="/api-admin-product"/>
<c:url var="productURL" value="/Admin-Product"/>
<c:url var="backURL" value="/Admin-Product">
    <c:param name="type" value="list"/>
    <c:param name="page" value="${oldPage}"/>
</c:url>
<!DOCTYPE html>
<html>
    <head>
        <title>Edit Product</title>
    </head>
    <body>
        <div class="main-content">
            <div class="main-content-inner">
                <div class="breadcrumbs" id="breadcrumbs">
                    <script type="text/javascript">
                        try {
                            ace.settings.check('breadcrumbs', 'fixed')
                        } catch (e) {
                        }
                    </script>
                    <ul class="breadcrumb">
                        <li>
                            <i class="ace-icon fa fa-home home-icon"></i>
                            <a href="${backURL}">Home</a>
                        </li>
                        <li class="active">Edit Product</li>
                    </ul><!-- /.breadcrumb -->
                </div>
                <div class="page-content">
                    <div class="row">
                        <div class="col-xs-12">
                            <c:if test="${not empty messageResponse}">
                                <div class="alert alert-${alert}">
                                    ${messageResponse}
                                </div>
                            </c:if>
                            <form id="formSubmit" >
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Category</label>
                                    <div class="col-sm-9">
                                        <select class="form-control" id="categoryCode" name="categoryCode">
                                            <c:if test="${empty model.categoryCode}">
                                                <option value="">Select category product</option>
                                                <c:forEach var="item" items="${categories}">
                                                    <option value='${item.code}'>${item.name}</option>
                                                </c:forEach>
                                            </c:if>
                                            <c:if test="${not empty model.categoryCode}">
                                                <c:forEach var="item" items="${categories}">
                                                    <option value="${item.code}" <c:if test="${item.code == model.categoryCode}">selected="selected"</c:if>>
                                                        ${item.name}
                                                    </option>
                                                </c:forEach>
                                                <option value="">Select category product</option>
                                            </c:if>
                                        </select>
                                    </div>
                                </div>
                                <br/>
                                <br/>
                                <br/>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Product name</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="name" name="name" value="${model.name}"/>
                                    </div>
                                </div>
                                <br/>
                                <br/>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Thumbnail</label>
                                    <div class="col-sm-9">
                                        <img id="imageBase64" src="${model.image_Link}" alt="alt" style="height: 100px; width: 100px"/>
                                        <div id="imgTest" style="height: 5px; width: 5px">
                                            <div style="height: 100px; width: 100px"></div>
                                        </div>
                                        <input type="file" class="form-control" id="inputFileToLoad" onchange="encodeImageFileAsURL();" name="image_Link" value="${model.image_Link}"/>

                                        
                                        <br/>
                                        <br/>
                                    </div>
                                </div>
                                <br/>
                                <br/>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Price</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="price" name="price" value="${model.price}"/>
                                    </div>
                                </div>
                                <br/>
                                <br/>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Quantity</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="quantity" name="quantity" value="${model.quantity}"/>
                                    </div>
                                </div>
                                <br/>
                                <br/>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Description</label>
                                    <div class="col-sm-9">                                 
                                        <textarea rows="" cols="" id="description" name="description" style="width: 820px;height: 160px">${model.description}</textarea>
                                    </div>
                                </div>
                                <br/>
                                <br/>
                                <div class="form-group" style="float: right" >
                                    <div class="col-sm-12" style="margin-top: 30px">
                                        <c:if test="${not empty model.name}">
                                            <input type="button" class="btn btn-white btn-warning btn-bold" value="Update product" id="btnAddOrUpdateProduct"/>
                                            <a class="btn btn-white btn-warning btn-bold" href='${backURL}'>
                                                Back
                                            </a>
                                        </c:if>
                                        <c:if test="${empty model.name}">
                                            <input type="button" class="btn btn-white btn-warning btn-bold" value="Add new product" id="btnAddOrUpdateProduct"/>
                                            <a class="btn btn-white btn-warning btn-bold" href='${backURL}'>
                                                Back
                                            </a>
                                        </c:if>
                                    </div>

                                </div>
                                <input type="hidden" value="${model.id}" id="id" name="id"/>
                                <input type="hidden" value="${model.image_Link}" id="image_Link" name="image_Link"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script type='text/javascript'>
            static base64 = null;
                    static idOld = null;
                    static oldName = null;
        </script>
        <script>
            function encodeImageFileAsURL() {

                var filesSelected = document.getElementById("inputFileToLoad").files;
                if (filesSelected.length > 0) {
                    var fileToLoad = filesSelected[0];

                    var fileReader = new FileReader();

                    fileReader.onload = function (fileLoadedEvent) {
                        var srcData = fileLoadedEvent.target.result; // <--- data: base64
                        base64 = fileLoadedEvent.target.result;
                        var newImage = document.createElement('img');
                        newImage.src = srcData;
                        document.getElementById("imageBase64").src = srcData;
                        document.getElementById("imageBase64").innerHTML = imageBase64.outerHTML;
                        console.log("Converted Base64 version is " + document.getElementById("imgTest").innerHTML);
                    }
                    fileReader.readAsDataURL(fileToLoad);
                }
            }
            ;
            $('#btnAddOrUpdateProduct').click(function (e) {
                e.preventDefault();
                var data = {};
                data["note"] = "";
                data["status"] = 1;
                var formData = $('#formSubmit').serializeArray();
                $.each(formData, function (i, v) {
                    data["" + v.name + ""] = v.value;
                });
                var id = $('#id').val();
                idOld = id;
                oldName = data["name"];
                if (id == 0) {
                    data["image_Link"] = base64;

                    addProduct(data);
                } else {
                    data["image_Link"] = $('#image_Link').val();
                    data["id"] = id;
                    updateProduct(data);
                }
                id = 0;
            });
            function addProduct(data) {
                $.ajax({
                    url: '${APIurl}',
                    type: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify(data),
                    dataType: 'text',
                    success: function (result) {
                        window.location.href = "${productURL}?type=edit&id=" + 0 + "&message=insert_success";
                    },
                    error: function (error) {
                        window.location.href = "${productURL}?type=edit&id=" + 0 + "&message=error_system";
                    }
                });
            }
            ;
            function updateProduct(data) {
                $.ajax({
                    url: '${APIurl}',
                    type: 'PUT',
                    contentType: 'application/json',
                    data: JSON.stringify(data),
                    dataType: 'text',
                    success: function (result) {
                        window.location.href = "${productURL}?type=edit&id=" + idOld + "&message=update_success&name=" + oldName;
                    },
                    error: function (error) {
                        window.location.href = "${productURL}?type=edit&id=" + idOld + "&message=error_system&name=" + oldName;
                    }
                });
            }
            ;
        </script>                 
    </body>
</html>
