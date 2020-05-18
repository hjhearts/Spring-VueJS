import MessageListItem from "./MessageListItem.js";
export default {
    name:'MessageList',
    template:`<ul>
        <message-list-item v-for="item in items" :item="item" @delete="deleteClick(item)">
        </message-list-item>
    </ul>`,
    components:{
        MessageListItem
    },
    props:{
        items:{
            type:Array,
            required:true
        }
    },
    methods:{
        deleteClick(item){
            this.$emit('delete', item);
        }
    }
}