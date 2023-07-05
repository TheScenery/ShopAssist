<script setup>
import IconGithub from '../icons/IconGithub.vue';
</script>
<template>
    <div class="sa-layout-header-container">
        <div class="left-part">
            <el-image style="width: 100px; height: 24px" src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg" :fit="fit" />
        </div>
        <div class="right-part">
            <el-avatar
                src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"
            />
            <el-link href="https://github.com/TheScenery/ShopAssist" :underline="false">
                <IconGithub class="github-icon"/>
            </el-link>
        </div>
    </div>
</template>
<style scoped lang="scss">
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