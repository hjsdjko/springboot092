"use strict";(self["webpackChunkvue3_nb0"]=self["webpackChunkvue3_nb0"]||[]).push([[240],{41240:(e,l,o)=>{o.r(l),o.d(l,{default:()=>k});o(63134),o(10307),o(39524);var a=o(67377),n=o(91370),u=o(51290),t=function(e){return(0,a.dD)("data-v-0e15f56b"),e=e(),(0,a.Cn)(),e},i={class:"login_view"},r=t((function(){return(0,a._)("div",{class:"title_view"},"民宿管理系统登录",-1)})),s={key:0,class:"list_item"},v=t((function(){return(0,a._)("div",{class:"list_label"}," 账号： ",-1)})),d={key:1,class:"list_item"},c=t((function(){return(0,a._)("div",{class:"list_label"}," 密码： ",-1)})),m=["onKeydown"],f={key:2,class:"list_type"},p=t((function(){return(0,a._)("div",{class:"list_label"}," 用户类型： ",-1)})),g={key:3,class:"remember_view"},w={class:"btn_view"};const _={__name:"login",setup:function(e){var l,o=(0,u.iH)([]),t=(0,u.iH)([]),_=(0,u.iH)({role:"",username:"",password:""}),h=(0,u.iH)(""),b=(0,u.iH)(1),k=(0,u.iH)(!0),y=null===(l=(0,a.FN)())||void 0===l?void 0:l.appContext.config.globalProperties,U=function(e){null===y||void 0===y||y.$router.push("/".concat(e,"Register"))},S=function(){if(_.value.username)if(_.value.password){if(o.value.length>1){if(!_.value.role)return null===y||void 0===y||y.$toolUtil.message("请选择角色","error"),void verifySlider.value.reset();for(var e=0;e<t.value.length;e++)t.value[e].roleName==_.value.role&&(h.value=t.value[e].tableName)}else h.value=o.value[0].tableName,_.value.role=o.value[0].roleName;$()}else null===y||void 0===y||y.$toolUtil.message("请输入密码","error");else null===y||void 0===y||y.$toolUtil.message("请输入用户名","error")},$=function(){null===y||void 0===y||y.$http({url:"".concat(h.value,"/login?username=").concat(_.value.username,"&password=").concat(_.value.password),method:"post"}).then((function(e){if(k.value){var l=JSON.parse(JSON.stringify(_.value));delete l.code,null===y||void 0===y||y.$toolUtil.storageSet("loginForm",JSON.stringify(l))}else null===y||void 0===y||y.$toolUtil.storageRemove("loginForm");null===y||void 0===y||y.$toolUtil.storageSet("Token",e.data.token),null===y||void 0===y||y.$toolUtil.storageSet("role",_.value.role),null===y||void 0===y||y.$toolUtil.storageSet("sessionTable",h.value),null===y||void 0===y||y.$toolUtil.storageSet("adminName",_.value.username),null===y||void 0===y||y.$router.push("/")}),(function(e){}))},N=function(){var e={page:1,limit:1,sort:"id"};null===y||void 0===y||y.$http({url:"menu/list",method:"get",params:e}).then((function(e){t.value=JSON.parse(e.data.data.list[0].menujson);for(var l=0;l<t.value.length;l++)"是"==t.value[l].hasBackLogin&&o.value.push(t.value[l]);var a=null===y||void 0===y?void 0:y.$toolUtil.storageGet("loginForm");a||(_.value.role=o.value[0].roleName),null===y||void 0===y||y.$toolUtil.storageSet("menus",JSON.stringify(t.value))}))},V=function(){N();var e=null===y||void 0===y?void 0:y.$toolUtil.storageGet("loginForm");e&&(_.value=JSON.parse(e))};return(0,a.bv)((function(){V()})),function(e,l){var u=(0,a.up)("el-option"),t=(0,a.up)("el-select"),h=(0,a.up)("el-checkbox"),y=(0,a.up)("el-button"),$=(0,a.up)("el-form"),N=(0,a.up)("Vcode");return(0,a.wg)(),(0,a.iD)("div",null,[(0,a._)("div",i,[(0,a.Wm)($,{model:_.value,class:"login_form"},{default:(0,a.w5)((function(){return[r,1==b.value?((0,a.wg)(),(0,a.iD)("div",s,[v,(0,a.wy)((0,a._)("input",{class:"list_inp","onUpdate:modelValue":l[0]||(l[0]=function(e){return _.value.username=e}),placeholder:"请输入账号"},null,512),[[n.nr,_.value.username]])])):(0,a.kq)("",!0),1==b.value?((0,a.wg)(),(0,a.iD)("div",d,[c,(0,a.wy)((0,a._)("input",{class:"list_inp","onUpdate:modelValue":l[1]||(l[1]=function(e){return _.value.password=e}),type:"password",placeholder:"请输入密码",onKeydown:(0,n.D2)(S,["enter","native"])},null,40,m),[[n.nr,_.value.password]])])):(0,a.kq)("",!0),o.value.length>1?((0,a.wg)(),(0,a.iD)("div",f,[p,(0,a.Wm)(t,{modelValue:_.value.role,"onUpdate:modelValue":l[2]||(l[2]=function(e){return _.value.role=e}),placeholder:"请选择用户类型"},{default:(0,a.w5)((function(){return[((0,a.wg)(!0),(0,a.iD)(a.HY,null,(0,a.Ko)(o.value,(function(e,l){return(0,a.wg)(),(0,a.j4)(u,{label:e.roleName,value:e.roleName},null,8,["label","value"])})),256))]})),_:1},8,["modelValue"])])):(0,a.kq)("",!0),1==b.value?((0,a.wg)(),(0,a.iD)("div",g,[(0,a.Wm)(h,{modelValue:k.value,"onUpdate:modelValue":l[3]||(l[3]=function(e){return k.value=e}),label:"记住密码",size:"large","true-label":!0,"false-label":!1},null,8,["modelValue"])])):(0,a.kq)("",!0),(0,a._)("div",w,[1==b.value?((0,a.wg)(),(0,a.j4)(y,{key:0,class:"login",type:"success",onClick:S},{default:(0,a.w5)((function(){return[(0,a.Uk)("登录")]})),_:1})):(0,a.kq)("",!0),(0,a.Wm)(y,{class:"register",type:"primary",onClick:l[4]||(l[4]=function(e){return U("yuangong")})},{default:(0,a.w5)((function(){return[(0,a.Uk)("注册员工")]})),_:1})])]})),_:1},8,["model"])]),(0,a.Wm)(N,{show:e.isShow,onSuccess:e.success,onClose:e.close,onFail:e.fail},null,8,["show","onSuccess","onClose","onFail"])])}}};var h=o(57326);const b=(0,h.Z)(_,[["__scopeId","data-v-0e15f56b"]]),k=b}}]);
//# sourceMappingURL=240.1585710c.js.map