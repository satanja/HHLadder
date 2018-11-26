(window.webpackJsonp=window.webpackJsonp||[]).push([[0],{134:function(e,t,n){"use strict";n.r(t);var a=n(0),r=n.n(a),l=n(10),o=n.n(l),i=(n(87),n(17)),c=n(18),u=n(22),s=n(19),d=n(23),m=n(24),h=n(135),f=n(25);function v(){var e=Object(m.a)(["\n  text-align: center;\n  font-weight: bold;\n  color: #000000;\n"]);return v=function(){return e},e}function E(){var e=Object(m.a)(["\n  width: 90%;\n  margin: 0 auto;\n"]);return E=function(){return e},e}var b=f.a.div(E()),p=f.a.caption(v()),y=function(e){var t=e.data,n=t.name,a=t.fencers,l=t.isHiddenMMR;return r.a.createElement(b,null,r.a.createElement(h.a,{striped:!0,bordered:!0,condensed:!0,hover:!0},r.a.createElement(p,null,n),r.a.createElement("thead",null,r.a.createElement("tr",null,r.a.createElement("th",null,"Position"),r.a.createElement("th",null,"Name"),l?null:r.a.createElement("th",null,"MMR"))),r.a.createElement("tbody",null,a.map(function(e,t){var n="".concat(t+1,"."),a=e.name,o=e.MMR;return r.a.createElement("tr",{key:n},r.a.createElement("td",null,n),r.a.createElement("td",null,a),l?null:r.a.createElement("td",null,o))}))))},S=n(80),k=n(136),g=n(137),w=n(142),O=n(138),C=n(139),j=n(66);function L(){var e=Object(m.a)(["\n  width: 90%;\n  margin: 0 auto;\n  background-color: #f9f9f9;\n  border: 1px solid #ddd;\n  padding: 2rem;\n  margin-top: 2rem;\n"]);return L=function(){return e},e}function I(){var e=Object(m.a)(["\n  text-align: center;\n"]);return I=function(){return e},e}var V=f.a.p(I()),M=f.a.div(L()),N=function(e){function t(e){var n;return Object(i.a)(this,t),(n=Object(u.a)(this,Object(s.a)(t).call(this,e))).state={name:"",id:"",ladders:e.ladders.map(function(e){return{name:e.name,isSelected:!1}}),nameValidation:null,idValidation:null,ladderValidation:null},n}return Object(d.a)(t,e),Object(c.a)(t,[{key:"updateName",value:function(e){var t=e.target.value;this.setState({name:t})}},{key:"updateId",value:function(e){var t=e.target.value;this.setState({id:t})}},{key:"updateCheckbox",value:function(e){var t=e.target,n=t.checked,a=t.name;this.setState(function(e){return Object(S.a)({},e,{ladders:e.ladders.map(function(e){return e.name===a?Object.assign(e,{isSelected:n}):e})})})}},{key:"canSubmit",value:function(e,t){var n=this.state.name.length,a=this.state.id.length;return n>0&&t.length>0&&a>0||(e.preventDefault(),this.validateNameLength(),this.validateId(),this.validateSelectedLadders(t),!1)}},{key:"validateNameLength",value:function(){var e=this.state.name.length;this.setState({nameValidation:0===e?"error":null})}},{key:"validateId",value:function(){var e=this.state.id.length;this.setState({idValidation:0===e?"error":null})}},{key:"validateSelectedLadders",value:function(e){var t=e.length;this.setState({ladderValidation:0===t?"error":null})}},{key:"onSubmit",value:function(e){var t=this.state.ladders.filter(function(e){return e.isSelected}).map(function(e){return{name:e.name}}),n={command:"add",name:this.state.name,ladders:t};this.canSubmit(e,t)&&this.props.onSubmit(n)}},{key:"render",value:function(){var e=this;return r.a.createElement(M,null,r.a.createElement(V,null,"Register"),r.a.createElement("form",null,r.a.createElement(k.a,{controlId:"formName",validationState:this.state.nameValidation},r.a.createElement(g.a,null,"Name"),r.a.createElement(w.a,{type:"text",autoComplete:"off",value:this.state.name,placeholder:"Enter your name",onChange:function(t){return e.updateName(t)}}),r.a.createElement(w.a.Feedback,null),"error"===this.state.nameValidation?r.a.createElement(O.a,null,"Enter a name of at least one character"):null),r.a.createElement(k.a,{controlId:"formId",validationState:this.state.idValidation},r.a.createElement(g.a,null,"Membership ID"),r.a.createElement(w.a,{type:"number",autoComplete:"off",value:this.state.id,placeholder:"Enter your membership ID",onChange:function(t){return e.updateId(t)}}),r.a.createElement(w.a.Feedback,null),"error"===this.state.idValidation?r.a.createElement(O.a,null,"Enter an id of length at least one"):null),r.a.createElement(k.a,{controlId:"formLadder",validationState:this.state.ladderValidation},r.a.createElement(g.a,null,"Select the ladders you want to join"),this.state.ladders.map(function(t,n){return r.a.createElement(C.a,{onChange:function(t){return e.updateCheckbox(t)},name:t.name,key:n},t.name)}),r.a.createElement(w.a.Feedback,null),"error"===this.state.ladderValidation?r.a.createElement(O.a,null,"Select at least one ladder"):null),r.a.createElement(j.a,{type:"submit",onClick:function(t){return e.onSubmit(t)}},"Submit")))}}]),t}(a.Component),x=n(141),W=n(140),K=function(e){function t(e){var n;return Object(i.a)(this,t),(n=Object(u.a)(this,Object(s.a)(t).call(this,e))).state={selectedLadder:"Select a ladder",winner:"Select the winner",loser:"Select the loser"},n}return Object(d.a)(t,e),Object(c.a)(t,[{key:"setLadder",value:function(e){this.setState({selectedLadder:e,winner:"Select the winner",loser:"Select the loser"})}},{key:"setWinner",value:function(e){this.setState({winner:e})}},{key:"setLoser",value:function(e){this.setState({loser:e})}},{key:"onSubmit",value:function(e){if("Select the winner"!==this.state.winner&&"Select the loser"!==this.state.loser){var t={command:"match",ladder:this.state.selectedLadder,fencers:{winner:this.state.winner,loser:this.state.loser}};this.props.onSubmit(t)}}},{key:"render",value:function(){var e=this,t=this.props.ladders;return r.a.createElement(M,null,r.a.createElement("form",null,r.a.createElement(V,null,"Bout"),r.a.createElement(k.a,{controlId:"formLadder"},r.a.createElement(g.a,null,"Ladder"),r.a.createElement("br",null),r.a.createElement(x.a,{bsStyle:"default",title:this.state.selectedLadder,id:1},t.map(function(t,n){return r.a.createElement(J,{eventKey:t.name,key:n,onSelect:function(t){return e.setLadder(t)},selected:e.state.selectedLadder},t.name)}))),r.a.createElement(k.a,{controlId:"formWinner"},r.a.createElement(g.a,null,"Winner"),r.a.createElement("br",null),r.a.createElement(x.a,{bsStyle:"success",title:this.state.winner,id:2},t.filter(function(t){return t.name===e.state.selectedLadder}).map(function(t){return t.fencers.map(function(t,n){return r.a.createElement(J,{eventKey:t.name,key:n,onSelect:function(t){return e.setWinner(t)},selected:e.state.winner},t.name)})}))),r.a.createElement(k.a,{controlId:"formLoser"},r.a.createElement(g.a,null,"Loser"),r.a.createElement("br",null),r.a.createElement(x.a,{bsStyle:"danger",title:this.state.loser,id:3},t.filter(function(t){return t.name===e.state.selectedLadder}).map(function(t){return t.fencers.map(function(t,n){return r.a.createElement(J,{eventKey:t.name,key:n,onSelect:function(t){return e.setLoser(t)},selected:e.state.loser},t.name)})}))),r.a.createElement(j.a,{type:"submit",onClick:function(){return e.onSubmit()}},"Submit")))}}]),t}(a.Component),J=function(e){var t=e.selected,n=e.eventKey,a=e.key,l=e.onSelect;return n===t?r.a.createElement(W.a,{eventKey:n,key:a,onSelect:function(e){return l(e)},active:!0},e.children):r.a.createElement(W.a,{eventKey:n,key:a,onSelect:function(e){return l(e)}},e.children)},R=K,B=function(e){function t(e){var n;return Object(i.a)(this,t),(n=Object(u.a)(this,Object(s.a)(t).call(this,e))).state={ladders:[]},n.connection=null,n.connect(),n}return Object(d.a)(t,e),Object(c.a)(t,[{key:"connect",value:function(){var e=this,t=window.location;this.connection=new WebSocket("".concat("https:"===t.protocol?"wss":"ws","://").concat(t.hostname,":4242")),this.connection.onclose=function(t){return e.onConnectionClose(t)},this.connection.onerror=function(t){return e.onConnectionError(t)},this.connection.onmessage=function(t){return e.onConnectionMessage(t)},this.connection.onopen=function(t){return e.onConnectionOpen(t)}}},{key:"onConnectionClose",value:function(e){console.log("Closed")}},{key:"onConnectionError",value:function(e){console.log("Error")}},{key:"onConnectionMessage",value:function(e){console.log("message received");var t=JSON.parse(e.data);void 0!==t.ladders&&this.setState({ladders:t.ladders})}},{key:"onConnectionOpen",value:function(e){console.log("Connected"),this.getLadders()}},{key:"getLadders",value:function(){this.submit({command:"ladders"})}},{key:"submit",value:function(e){this.connection.send(JSON.stringify(e))}},{key:"render",value:function(){var e=this,t=this.state.ladders;return r.a.createElement("div",null,0===t.length?null:r.a.createElement("div",null,r.a.createElement(N,{onSubmit:function(t){return e.submit(t)},ladders:t}),r.a.createElement(R,{ladders:t,onSubmit:function(t){return e.submit(t)}})),t.map(function(e,t){return r.a.createElement(y,{data:e,key:t})}))}}]),t}(a.Component);Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));o.a.render(r.a.createElement(B,null),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then(function(e){e.unregister()})},82:function(e,t,n){e.exports=n(134)},87:function(e,t,n){}},[[82,2,1]]]);
//# sourceMappingURL=main.057c77ad.chunk.js.map