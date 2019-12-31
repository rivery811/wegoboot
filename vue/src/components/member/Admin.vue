<template>
<div class="back">
     <div align = "center"><h1>{{person.name}}어드민</h1></div>
      <div class="sub">
        <div class="pull-left rt size" >
           <fieldset style=" margin-top: 1%; height: 31.5%;border: 2px solid black;">
             <legend><h3>비밀번호 </h3></legend>
                <h4>{{person.passwd}}</h4>
                
           </fieldset>
           <fieldset style="margin-top: 1%; height: 60%;border: 2px solid black;">
              <legend><h3>학생부관리</h3></legend>
                <h4>{{person.hak}}학년</h4>
                <h4>{{person.ban}}반</h4>
                <h4>{{person.score}}</h4>
                <br/><br/>
                <button @click.prevent="goupdate">수정</button>	
           </fieldset>
        </div>
      </div>
    </div>
</template>
<script>
import {store} from "../../store"


export default{
  data(){
    return {
      context:'http://localhost:8080/',
      person : store.state.person,
      newscore:''      
    }
  }
}
</script>
<style scoped>
</style>