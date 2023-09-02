<script setup>
import { ref } from 'vue';
import { login } from '@/api/auth';
import { saveToken } from '@/util/token';
import { useRouter } from 'vue-router';

const router = useRouter();

const loginData = ref({
  userName: '',
  password: ''
});

const onLogin = async () => {
  const result = await login(loginData.value);
  saveToken(result.token);
  await router.push('/');
};

</script>

<template>
  <div class='login-view-container'>
    <div class='login-form-container'>
      <el-form label-position='top' :model='loginData'>
        <el-form-item label='User Name'>
          <el-input v-model='loginData.userName'></el-input>
        </el-form-item>
        <el-form-item label='Password'>
          <el-input v-model='loginData.password' type='password' show-password></el-input>
        </el-form-item>
        <el-button type='primary' round class='login-button' @click='onLogin'>
          Login
        </el-button>
      </el-form>
    </div>
  </div>
</template>

<style scoped lang='scss'>
.login-view-container {
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;

  .login-form-container {
    width: 300px;

    .login-button {
      width: 100%;
    }
  }
}
</style>