<script setup>
import { onMounted, ref } from 'vue';
import { createApp, getMyApps } from '@/api/app';
import CreateAPP from '@/biz-components/create-app/CreateAPP.vue';

const apps = ref([]);

onMounted(async () => {
  apps.value = await getMyApps();
});

const onCreateAPP = async (data) => {
  const resp = await createApp({ name: data })
  console.log("create a new app, app id is: ", resp.id);
};

</script>

<template>
  <div class='workspaces-container'>
    <CreateAPP @createAPP='onCreateAPP' />
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