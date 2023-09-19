<script setup>
import { Edit } from '@element-plus/icons-vue';
import { onMounted, ref } from 'vue';
import { getMyApps } from '@/api/app';

const apps = ref([]);

onMounted(async () => {
  apps.value = await getMyApps();
});

</script>

<template>
  <div class='workspaces-container'>
    <el-button type='primary' :icon='Edit' class='create-workspace-button'>{{ $t('app.create') }}</el-button>
    <div class='workspaces-list-container'>
      <el-space wrap size='large'>
        <el-card v-for='workspace in apps' :key='workspace.id' class='workspace-container'>
          {{ workspace.name }}
        </el-card>
      </el-space>
    </div>
  </div>
</template>

<style scoped lang='scss'>
.workspaces-container {
  padding: 2rem 10rem;
  width: 100%;

  .create-workspace-button {
    width: 10rem;
  }

  .workspaces-list-container {
    padding: 2rem 0;

    .workspace-container {
      width: 15rem;
    }
  }
}
</style>