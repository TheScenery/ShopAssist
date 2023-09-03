<script setup>
import { onMounted, ref } from 'vue';
import { getCurrentUserInfo } from '@/api/auth';
import logo from '@/assets/ShopAssist.png';

const currentUser = ref({ avatar: '', name: '' });
onMounted(async () => {
  const userInfo = await getCurrentUserInfo();
  currentUser.value = userInfo;
});

</script>
<template>
  <div class='sa-layout-header-container'>
    <div class='left-part'>
      <el-image
        style='width: 150px; height: 34px'
        :src='logo'
      />
    </div>
    <div class='right-part'>
      <el-avatar :src='currentUser.avatar' />
    </div>
  </div>
</template>
<style scoped lang='scss'>
.sa-layout-header-container {
  display: flex;
  padding: 8px 0;
  align-items: center;
  justify-content: space-between;
  border-bottom: 1px solid var(--color-border);

  .right-part {
    display: flex;

    .github-icon {
      font-size: 40px;
      margin-left: 16px;
    }
  }
}
</style>
