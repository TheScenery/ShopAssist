<script setup>
import { Edit } from '@element-plus/icons-vue';
import { onMounted, ref } from 'vue';
import { getMyApps } from '@/api/app';
import ModalDialog from '@/components/dialog/ModalDialog.vue';

const apps = ref([]);
const createDialogOpen = ref(false);

onMounted(async () => {
  apps.value = await getMyApps();
});

const openCreateAppDialog = () => {
  createDialogOpen.value = true;
};

const createApp = () => {
  console.log('create app');
};

</script>

<template>
  <div class='workspaces-container'>
    <el-button type='primary' :icon='Edit' class='create-workspace-button' @click='openCreateAppDialog'>{{ $t(
      'app.create') }}
    </el-button>
    <div class='workspaces-list-container'>
      <el-space wrap size='large'>
        <el-card v-for='workspace in apps' :key='workspace.id' class='workspace-container'>
          {{ workspace.name }}
        </el-card>
      </el-space>
    </div>
    <ModalDialog v-model='createDialogOpen' @onOk='createApp' :title='$t("app.create")'>
      This is create app dialog
    </ModalDialog>
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