<script setup>

import { Edit } from '@element-plus/icons-vue';
import { ref } from 'vue';
import ModalDialog from '@/components/dialog/ModalDialog.vue';
import { useI18n } from 'vue-i18n';

const emit = defineEmits(['createAPP']);

const { t } = useI18n();

const createDialogOpen = ref(false);
const appName = ref(t('app.defaultAppName'));

const openCreateAppDialog = () => {
  createDialogOpen.value = true;
};

const createApp = () => {
  emit('createAPP', appName.value);
};
</script>

<template>
  <div>
    <el-button type='primary' :icon='Edit' class='create-workspace-button' @click='openCreateAppDialog'>{{ $t(
      'app.create') }}
    </el-button>
    <ModalDialog v-model='createDialogOpen' @onOk='createApp' :title='$t("app.create")'>
      <el-input v-model='appName' />
    </ModalDialog>
  </div>
</template>

<style scoped lang='scss'>

</style>