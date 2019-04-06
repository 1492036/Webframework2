<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container">
	<h2>Product Detail</h2>
	<p>디테일한 정보를 보여주는 화면입니다.</p>
<div class="row">
	<div class="col-md-6">
		<c:set var="imageFilename" value="/resources/image/${product.id}.jpg"/>
		<img src="<c:url value="${imageFilename}"/>" alt="image"
		style="width:80%"/>
		
		<div class = "col-md-6">
			<h3>${product.name}</h3>
			<p>${product.description}</p>
			<p>Manufacturer: ${product.manufacturer}</p>
			<p>Category: ${product.category}</p>
			<h3>${product.price}</h3>
		</div>
	</div>
</div>
</div>