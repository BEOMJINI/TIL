
class Item {
    constructor(name) {
        this.name = name;
        this.itemList = [];


    }

    addItemList(name) {
        this.itemList.push(new Item(name));
    }

    openItemList(message) {
        message.style.opacity = 1;
        message.innerHTML = '[아이템목록]<br>&nbsp;&nbsp;&nbsp;&nbsp; '
        if (this.itemList.length == 0) {
            message.innerHTML += '가지고 있는 아이템이 없습니다.'
        } else {
            for (let i = 0; i < this.itemList.length; i++) {
                message.innerHTML += `${this.itemList[i].name}&nbsp;`;
            }

        }

        setTimeout(() => {
            message.innerHTML = "";
            message.style.opacity = 0;
        }, 2000);
    }






}