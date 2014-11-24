define([
'kendo/kendo.data.min', 'robe/Validations'
], function() {

var ${entity}  = kendo.data.Model.define({
id: "oid",
fields: {
oid: {
editable: false,
nullable: true,
type: "string"
},
<#list fields as field>
${field.name} :{
editable : true,
nullable : ${field.nullable?string},
validation : getValidations("${field.name}","${field.name}", ${(!field.nullable)?string}, false, 0, ${field.length}, ""),
type:"${field.type}"
}<#if field_has_next>,</#if>
</#list>
}
});
return ${entity};
});