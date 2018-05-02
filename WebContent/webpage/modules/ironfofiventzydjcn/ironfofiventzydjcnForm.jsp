<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>冬季采暖管理</title>
	<meta name="decorator" content="default"/>
	<!-- <script type="text/javascript">
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
			
		});
	</script> -->
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfofiventzydjcn" action="${ctx}/ironfofiventzydjcn/ironfofiventzydjcn/save" method="post" class="form-horizontal">
	<%-- 	<form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td class="width-15 active"><label class="pull-right">备注信息：</label></td>
					<td class="width-35">
						<form:textarea path="remarks" htmlEscape="false" rows="4"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">主表id：</label></td>
					<td class="width-35">
						<form:input path="doc_id" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">中央空调：</label></td>
					<td class="width-35">
						<radiobuttons path="zykt" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
					<td class="width-15 active"><label class="pull-right">分体空调：</label></td>
					<td class="width-35">
						<form:radiobuttons path="ftkt" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">锅炉采暖：</label></td>
					<td class="width-35">
						<form:radiobuttons path="glcn" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
					<td class="width-15 active"><label class="pull-right">电暖气：</label></td>
					<td class="width-35">
						<form:radiobuttons path="dzq" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">市政热力：</label></td>
					<td class="width-35">
						<form:radiobuttons path="szrl" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
					<td class="width-15 active"></td>
		   			<td class="width-35" ></td>
		  		</tr>
		 	</tbody>
		</table>
	</form>
</body>
</html>