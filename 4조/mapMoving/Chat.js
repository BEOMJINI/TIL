class Chat {
    constructor() {
        this.chat = new Map();
        this.init();
    }
    //map.set(key, value)
    init() {
        this.chat.set('바다', '파도가 부드럽게 넘실거리고 있다.');
        this.chat.set('나무', '큰 나무가 서있다.')
        this.chat.set('풍차', '풍차다.');
        this.chat.set('정원', '사과를 얻었다 !');
        this.chat.set('숲', '숲이 우거져있다.');
        this.chat.set('집', '집이다.');
        this.chat.set('냉장고', '냉장고에서 콜라를 꺼냈다.');
        this.chat.set('컴퓨터', '공부를 합시다.');
    }
}