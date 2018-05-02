<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>销售量管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		var validateForm;
		function doSubmit(){//回调函数，在编辑和保存动作时，供openDialog调用提交表单。
		  if(validateForm.form()){
			  $("#inputForm").submit();
			  return true;
		  }
	
		  return false;
		}
		$(document).ready(function() {
			validateForm = $("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
			
			laydate({
	            elem: '#datestr', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
	            event: 'focus' //响应事件。如果没有传入event，则按照默认的click
	        });
			
		});
	</script>
</head>
<body class="hideScroll">
		<form:form id="inputForm" modelAttribute="checks" action="${ctx}/statistics/checks/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<td class="width-15 active"><label class="pull-right">日期：</label></td>
					<td class="width-35">
						<input id="datestr" name="datestr" type="text" maxlength="20" class="laydate-icon form-control layer-date "
							value="<fmt:formatDate value="${checks.datestr}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
					</td>
				<tr>
					<td class="width-15 active"><label class="pull-right">订单总金额：</label></td>
					<td class="width-35">
						<form:input path="total_amount" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">折扣金额：</label></td>
					<td class="width-35">
						<form:input path="discount_amount" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">优惠券金额：</label></td>
					<td class="width-35">
						<form:input path="coupon_amount" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">积分抵扣金额：</label></td>
					<td class="width-35">
						<form:input path="integral_amount" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">运费：</label></td>
					<td class="width-35">
						<form:input path="freight_amount" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">商品金额：</label></td>
					<td class="width-35">
						<form:input path="com_amount" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				
		 	</tbody>
		</table>
	</form:form>
</body>
</html>