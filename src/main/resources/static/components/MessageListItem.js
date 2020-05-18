// import lifecycleLogger from "../mixin/lifecycle-logger.mixin.js"
export default {
    name: 'MessageListItem',
    // mixins:[lifecycleLogger],
    template: `<ul><li>{{ item.text }} - {{ item.createdAt | datetime}}
        <button @click="deleteClicked">X</button></li></ul>`,
    props: {
        item: {
            type: Object,
            required: true
        }
    },
    methods: {
        deleteClicked () {
            this.$emit('delete')
        }
    }
}