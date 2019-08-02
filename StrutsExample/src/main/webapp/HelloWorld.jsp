
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="layout" uri="http://struts.application-servers.com/layout" %>
<%--<%@ taglib uri="/WEB-INF\struts-layout.tld" prefix="layout" %>--%>


<html>
<head>
</head>
<body>
<h1><bean:write name="helloWorldForm" property="message" />
    <p>
        salam
    </p>

<layout:form action="">
    <layout:select key="lbl.pcPosParameters.portName"
                    mode="E,E,D" property="">
        <layout:option value="" key="lbl.default.select"/>
        <layout:optionsCollection property="portNames" label="message" value="value"/>
    </layout:select>
</layout:form>
</h1>
</body>
</html>