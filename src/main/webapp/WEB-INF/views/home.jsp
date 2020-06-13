<!--  
 *
 * @author PhucTV7
 *
 * Version 1.0
 *
 * @date 06/06/2020
 *
 * Copyright
 *
 */
-->

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-type"
	content="application/vnd.ms-excel; charset=UTF-8">
<title>新ﾃﾞﾎﾟ変換マスター更新</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>

	<div class="container-fluid">
		<div class="row text-center h mt-3 h pt-1 ml-0 mb-4">
			<div class="col-4 text-left ml-0 pl-0">
				<h4 class="">AUTA821</h4>
			</div>
			<div class="col-4 ">
				<h4>新ﾃﾞﾎﾟ変換マスター更新</h4>
			</div>
			<div class="col-4 text-right pr-0 ">
				<h4 id="time"></h4>
			</div>
		</div>

		<div class="mb-1">
			<label class="text-success" id="success"
				style="display: inline-block;"> <c:if
					test="${not empty message}">
				${message}
			</c:if>
			</label> <label  class="error text-danger" id="error"
				style="display: inline-block;"> <c:if
					test="${not empty error}">
				${error}
			</c:if>
			</label>
		</div>
		<mvc:form action="${pageContext.request.contextPath}/search" id="form"
			method="get" class="mt-3 mb-5">
			<div class="row ">
				<div class="col-sm-12 col-md-12 col-lg-3 ml-0">
					<div class="form-group row">
						<label class="col-sm-12 col-lg-4 col-md-12 mr-0 ml-0 mt-1"
							for="maker">メーカー</label>
						<div class="col-sm-12 col-lg-8 col-md-12">
							<select id="maker" class="form-control ml-0 p-0" name="maker">
								<c:choose>
									<c:when test="${not empty maker }">
										<option  selected value="${maker}">&nbsp;&nbsp;${maker}</option>
									</c:when>
									<c:otherwise>
										<option selected value=""></option>
									</c:otherwise>
								</c:choose>
								<c:forEach var="m" items="${listMakers}">
									<c:if test="${m.maker != maker }">
										<option value="${m.maker }">&nbsp;&nbsp;${m.maker}</option>
									</c:if>
								</c:forEach>
							</select>

						</div>
					</div>
					<div class="form-group row">
						<label for="deliveryLocationCode"
							class="col-sm-12 col-lg-4 col-md-12  mr-0 mt-1">搬入場所</label>
						<div class="col-sm-12 col-lg-8 col-md-12">
							<input type="text" class="form-control ml-0"
								id="deliveryLocationCode" name="deliveryLocationCode"
								value="${deliveryLocationCode}">
						</div>
					</div>
				</div>

				<div class="col-sm-12 col-lg-6 col-md-12">
					<div class="form-group row">
						<label for="manufactureCode"
							class="col-sm-12 col-lg-2 col-md-12 text-lg-right mt-1">ﾒｰｶｰ品番</label>
						<div class="col-sm-12 col-lg-10 col-md-12 x "
							style="padding-left: 20px;">
							<input type="text" class="form-control" name="manufactureCode"
								id="manufactureCode" value="${manufactureCode}" id="">
						</div>
					</div>
					<div class="form-group row">
						<div class="col-lg-5 col-md-12">
							<div class="form-group row">
								<label for="shippingDepotCode"
									class="col-sm-12 col-lg-5 text-lg-right col-md-12 mt-1">出荷デポ</label>
								<div class="col-sm-12 col-lg-7 col-md-12">
									<input type="text" class="form-control" id="shippingDepotCode"
										name="shippingDepotCode" value="${shippingDepotCode}">
								</div>
							</div>
						</div>
						<div class="col-lg-1"></div>
						<div class="col-sm-12 col-lg-6 col-md-12">
							<div class="form-group row">
								<label for="shippingDepotName"
									class="col-sm-12 col-lg-4 text-lg-right col-md-12 mt-1">参照</label>
								<div class="col-sm-12 col-lg-8 col-md-12">
									<input readonly type="text" style="width: 100%;" name="shippingDepotName" value="${shippingDepotName}"
										id="shippingDepotName" class="form-control">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-12 col-lg-3 col-md-12">
					<div class="form-group row">
						<label for="sScode"
							class="col-sm-12 col-lg-5 col-md-12 text-lg-right pl-lg-5 b mt-1">SS</label>
						<div class="col-sm-12 col-lg-7 col-md-12">
							<input type="text" class="form-control" name="sScode" id="sScode"
								value="${sScode}">
						</div>
					</div>
					<div class="form-group row">
						<label for="carType"
							class="col-sm-12 col-lg-5 col-md-12 text-lg-right pl-lg-5 b mt-1">車種</label>
						<div class="col-sm-12 col-lg-7 col-md-12 ml-0">
							<input type="text" class="form-control ml-0" name="carType"
								id="carType" value="${carType}">
						</div>
					</div>
				</div>

			</div>
			<div class="mb-3">
				<a href="#" class="btn btn-primary float-right mr-1">新規登録 (N)</a> <a
					href="${pageContext.request.contextPath}/list"
					class="btn btn-primary float-right mr-1">キャンセル (C)</a>
				<button type="submit" class="btn btn-primary float-right mr-1">検索
					(S)</button>
			</div>
		</mvc:form>

	</div>
	<div class="container-fluid">
		<div id="form-search" class="form-inline mt-5 s">
			<div style="color: white;"
				class="input-group mb-2 mr-sm-2 pt-2 pl-4 row">
				<c:if test="${totalPage > 0 }">
					<div class="pt-2 mr-2">${currentPage + 1 }/${totalPage}</div>
				</c:if>
				<div class="pt-2 mr-2">ペ ー ジ</div>
				<!-- pagination -->
				<a
					href="${pageContext.request.contextPath}/list?page=${currentPage - 1}&&size=${size}"
					class="btn btn btn-primary-outline mr-2 <c:if test="${currentPage == 0 }"> disabled </c:if>">
					<i class="fa fa-arrow-left" aria-hidden="true"></i>
				</a> <a
					href="${pageContext.request.contextPath}/list?page=${currentPage + 1}&&size=${size}"
					class="btn btn btn-primary-outline mr-2 <c:if test="${(currentPage + 1 ) >= totalPage }"> disabled </c:if>">
					<i class="fa fa-arrow-right" aria-hidden="true"></i>
				</a>
				<div class="pt-2  mr-2">ペ ー ジ</div>
				<!-- search by page -->
				<mvc:form action="${pageContext.request.contextPath}/list"
					method="get">
					<input type="hidden" name="size" value="${size}">
					<input required style="width: 5rem" type="number" 
					onchange="this.setCustomValidity('')"
						oninvalid="this.setCustomValidity('ページは存在しません')"
						oninput="this.setCustomValidity('')" min="1" max="${totalPage }"
						 class="form-control w-1 mr-1"
						value="${currentPage + 1}" name="pageInput" id="" placeholder="">
					<button class="btn btn btn-primary-outline ml-1 mr-2" type="submit">表
						示</button>
				</mvc:form>
				<div class="pt-2  mr-2">表 示 件 数</div>
				<!-- sellect number item in 1 page -->
				<mvc:form action="${pageContext.request.contextPath}/list"
					method="get">
					<select style="width: auto;" name="size"
						class=" form-control  mr-2 ">
						<c:forEach var="i" begin="0" end="9" step="1" varStatus="loop">
							<c:choose>
								<c:when test="${size == (10 - i)}">
									<option selected value="${10 - i}">${10 - i}</option>
								</c:when>
								<c:otherwise>
									<option value="${10 - i}">${10 - i}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
					<button class="btn btn btn-primary-outline" type="submit">表
						示</button>
				</mvc:form>
			</div>
		</div>
		<mvc:form modelAttribute="autdphkmform"
			action="${pageContext.request.contextPath}/update" id="form"
			method="post">
			<table id="table"
				class="table table-striped table-bordered table-hover text-center table-responsive">

				<thead style="background-color: rgb(20, 100, 248); color: white;">
					<tr>
						<th style="width: 2%">&nbsp;</th>
						<th style="width: 5%">OP</th>
						<th style="width: 10%">メーカー</th>
						<th style="width: 10%">メーカー名</th>
						<th style="width: 7%">SS</th>
						<th style="width: 7%">ＳＳ名</th>
						<th style="width: 10%">搬入場所</th>
						<th style="width: 25%" scope="col" colspan="2">出荷デポ<span
							style="color: red;">(*)</span></th>
						<th style="width: 10%">出荷デポ名</th>
						<th style="width: 10%">メーカ品番</th>
						<th style="width: 4%">車種</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="a" items="${autdphkmform.autdphkms}"
						varStatus="loop">
						<tr>
							<td class="pt-3">${loop.index + 1 }<input type="hidden"
								name="size" value="${size}"> <input type="hidden"
								name="page" value="${currentPage}">
							</td>

							<td><input maxlength="1" type="text" class="form-control"
								data="OP" name="autdphkms[${loop.index}].OP"></td>

							<td><input readonly type="text" class="form-control"
								value="${a.aUTMFOPM.maker }"
								name="autdphkms[${loop.index}].aUTMFOPM.maker"></td>
							<td><input readonly type="text" class="form-control"
								value="${a.aUTMFOPM.makerName}"
								name="autdphkms[${loop.index}].aUTMFOPM.makerName"></td>
							<td><input value="${a.sScode }" readonly maxlength="10"
								type="text" name="autdphkms[${loop.index}].sScode"
								class="form-control"></td>
							<td><input value="${a.sSName }" readonly maxlength="8"
								type="text" name="autdphkms[${loop.index}].sSName"
								class="form-control "></td>
							<td><input value="${a.deliveryLocationCode }" readonly
								maxlength="8" type="text"
								name="autdphkms[${loop.index}].deliveryLocationCode"
								class="form-control " id=""></td>
							<td style="width: 7%" class="text-center">
							<input
								value="${a.aUTMFOPM.shippingDepotCode}"
								name="autdphkms[${loop.index}].id" type="hidden"
								class="form-control">
							<input
								value="${a.aUTMFOPM.shippingDepotCode}" data="shippingDepot"
								name="autdphkms[${loop.index}].aUTMFOPM.shippingDepotCode"
								style="width: 100%" maxlength="2" type="text"
								class="form-control"></td>

							<td style="width: 7%" class="text-center">
								<button style="width: 100%" class="btn btn btn-primary" type="button"
									name="reference">参照</button>
							</td>

							<td><input readonly maxlength="2" type="text"
								data="shippingDepotName" value="${a.aUTMFOPM.shippingDepotName}"
								name="autdphkms[${loop.index}].aUTMFOPM.shippingDepotName"
								class="form-control"></td>
							<td><input type="text" readonly class="form-control" data="manufactureCode"
								name="autdphkms[${loop.index}].AUTTOKIM.manufactureCode"
								value="${a.aUTTOKIM.manufactureCode}"></td>

							<td><input name="autdphkms[${loop.index}].carType"
								maxlength="1" type="text" data="carType" readonly
								value="${a.carType}" class="form-control" id=""></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="">
				<c:if test="${autdphkmform.autdphkms.size() > 0 }">
					<button type="button" id="export-btn"
						class="btn btn-primary float-right mr-1">エクスポート(E)</button>
					<a id="r" href="${pageContext.request.contextPath}/list?page=${currentPage}&&size=${size}"
						class="btn btn-primary float-right mr-1">クリアー(R)</a>
					<button type="submit" id="u"
						class="btn btn-primary float-right mr-1">更新(U)</button>
				</c:if>
			</div>
		</mvc:form>
	</div>

	<script type="text/javascript">
		var context = "${pageContext.request.contextPath}";
		var line;
	</script>

	<c:if test="${not empty line }">
		<script type="text/javascript">
			var line = "${line}";
		</script>
	</c:if>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/validator.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/excel.js"></script>

</body>

</html>