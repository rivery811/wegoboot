<template>
	<div class="login-form">
    <form >
        <h2 class="text-center">Log in</h2>       
        <div class="form-group">
            <input type="text" v-model ="userid" class="form-control" placeholder="Username" required="required">
        </div>
        <div class="form-group">
            <input type="password" v-model ="passwd" class="form-control" placeholder="Password" required="required">
        </div>
        <div class="form-group">
            <button @click.prevent="login" type="submit" class="btn btn-primary btn-block">Log in</button>
        </div>
        <div class="clearfix">
            <label class="pull-left checkbox-inline"><input type="checkbox"> Remember me</label>
            <a href="#" class="pull-right">Forgot Password?</a>
        </div>        
    </form>
    <p class="text-center"><router-link to="/join">Create an Account</router-link></p>
</div>
</template>
<script>
import { createNamespacedHelpers } from 'vuex'

const { mapState } = createNamespacedHelpers('@/store/modules/admin')

export default{
	computed: {
    // `some/nested/module`에서 찾음
    ...mapState({
      userid: state => state.login,
      passwd: state => state.passwd
    })
  },
  methods: {
    login(){
		this.$store.dispatch(this.$store.state.userid,this.$store.state.passwd)
	}
  }
}
</script>
<style scoped>
.login-form {
	width: 340px;
	margin: 50px auto;
}
.login-form form {
	margin-bottom: 15px;
	background: #f7f7f7;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}
.login-form h2 {
	margin: 0 0 15px;
}
.form-control, .btn {
	min-height: 38px;
	border-radius: 2px;
}
.btn {        
	font-size: 15px;
	font-weight: bold;
}
</style>