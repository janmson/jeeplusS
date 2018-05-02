<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>5.5公共卫生用房管理</title>
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
			
		});
	</script>
</head>
<body class="hideScroll">
		<form:form id="inputForm" modelAttribute="ironfofiveggwsyf" action="${ctx}/ironfofiveggwsyf/ironfofiveggwsyf/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td class="width-15 active"><label class="pull-right">备注信息：</label></td>
					<td class="width-35">
						<form:textarea path="remarks" htmlEscape="false" rows="4"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">功能单元建筑面积（m2）：</label></td>
					<td class="width-35">
						<form:input path="gndyjzmj" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">健康档案室：</label></td>
					<td class="width-35">
						<form:radiobuttons path="jkdas" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
					<td class="width-15 active"><label class="pull-right">健康教育室：</label></td>
					<td class="width-35">
						<form:radiobuttons path="jkjys" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">预检区-接种大厅：</label></td>
					<td class="width-35">
						<form:radiobuttons path="yjqjzdt" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
					<td class="width-15 active"><label class="pull-right">候种区-接种大厅：</label></td>
					<td class="width-35">
						<form:radiobuttons path="hzqjzdt" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">接种区-接种大厅：</label></td>
					<td class="width-35">
						<form:radiobuttons path="jzqjzdt" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
					<td class="width-15 active"><label class="pull-right">冷凝区-接种大厅：</label></td>
					<td class="width-35">
						<form:radiobuttons path="lnqjzdt" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">妇女保健室-接种大厅：</label></td>
					<td class="width-35">
						<form:radiobuttons path="fnbjsjzdt" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
					<td class="width-15 active"><label class="pull-right">儿童保健室-接种大厅：</label></td>
					<td class="width-35">
						<form:radiobuttons path="etbjsjzdt" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">老年人保健室-接种大厅：</label></td>
					<td class="width-35">
						<form:radiobuttons path="lnrbjsjzdt" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
					<td class="width-15 active"><label class="pull-right">一般检查区-体检中心：</label></td>
					<td class="width-35">
						<form:radiobuttons path="ybjcqtjzx" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">口腔检查区-体检中心：</label></td>
					<td class="width-35">
						<form:radiobuttons path="kqjcqtjzx" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
					<td class="width-15 active"><label class="pull-right">听力检查区-体检中心：</label></td>
					<td class="width-35">
						<form:radiobuttons path="tljcqtjzx" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">视力检查区-体检中心：</label></td>
					<td class="width-35">
						<form:radiobuttons path="sljcqtjzx" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
					<td class="width-15 active"><label class="pull-right">智力检查区-体检中心：</label></td>
					<td class="width-35">
						<form:radiobuttons path="zljcqtjzx" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">男外科检查室-体检中心：</label></td>
					<td class="width-35">
						<form:radiobuttons path="nwkjcstjzx" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
					<td class="width-15 active"><label class="pull-right">女外科检查室-体检中心：</label></td>
					<td class="width-35">
						<form:radiobuttons path="nwkjcstjzx" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">其它（请注明）：</label></td>
					<td class="width-35">
						<form:input path="qtqzm" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">主表id：</label></td>
					<td class="width-35">
						<form:input path="doc_id" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
		 	</tbody>
		</table>
	</form:form>
</body>
</html>