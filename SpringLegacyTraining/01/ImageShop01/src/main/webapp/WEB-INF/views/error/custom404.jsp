<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<h2><spring:message code="common.error.urlNotFound" /></h2>

<a href="javascript:window.history.back();"><spring:message code="common.error.backPage" /></a><br>
<a href="/"><spring:message code="common.error.returnHome" /></a>