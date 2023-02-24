const canvas = document.querySelector('#test');
// canvas.setAttribute("width", window.innerWidth);
// canvas.setAttribute("height", window.innerHeight);
const ctx = canvas.getContext('2d');
const message = document.querySelector('.message');

let keyDown = {};
let mainObjectList = [];
let mapList = [new Map1(), new Map2(), new Map3(), new Map4(), new Map5()];
let mapLoad = 0;
let chat = new Chat();
let item = new Item();

let currentMapName = "메인맵";

let chatScriptName = "";

let bugCount = 0;
let walkCount = 0;

const testmap = new Map4();
let backImg = new Image();
backImg.src = "";
// backImg.addEventListener('load', () => {
//     ctx.drawImage(backImg, 0, 0, 800, 600);
// });

mapList.forEach((e) => {
    // console.log(e.objList);
})

addEventListener('keydown', (e) => {
    keyDown[e.key] = true;
})

addEventListener('keyup', (e) => {
    keyDown[e.key] = false;
})

class Player {
    constructor() {
        this.x = 0;
        this.y = 0;
        this.size = 50;
        this.speed = 5;
        this.color = 'red';
        this.img = "";
    }

    movePlayer() {
        let px = this.x;
        let py = this.y;
        let ps = this.size;
        let isCrash = false;


        if (keyDown['w']) {
            this.y -= this.speed;
            walkCount += 1;
            if (walkCount % 5 == 0) {
                this.img = 'img/top1.png';
            } else {
                this.img = 'img/top2.png';
            }
            if (walkCount == 100) {
                walkCount = 0;
            }
        } else if (keyDown['s']) {
            this.y += this.speed;
            walkCount += 1;
            if (walkCount % 5 == 0) {
                this.img = 'img/bottom1.png';
            } else {
                this.img = 'img/bottom2.png';
            }
            if (walkCount == 100) {
                walkCount = 0;
            }
        } else if (keyDown['a']) {
            this.x -= this.speed;
            walkCount += 1;
            if (walkCount % 5 == 0) {
                this.img = 'img/left1.png';
            } else {
                this.img = 'img/left2.png';
            }
            if (walkCount == 100) {
                walkCount = 0;
            }
        } else if (keyDown['d']) {
            this.x += this.speed;
            walkCount += 1;
            if (walkCount % 5 == 0) {
                this.img = 'img/right1.png';
            } else {
                this.img = 'img/right2.png';
            }
            if (walkCount == 100) {
                walkCount = 0;
            }
        } else if (keyDown['f']) {

            if (chatScriptName == "") {
                return;
            }
            if (message.style.opacity == 1) {
                return;
            }
            if (chatScriptName == '정원') {
                if (bugCount == 5) {
                    item.addItemList('사과');
                    printMessage(chat.chat.get(chatScriptName));
                    chatScriptName = "";
                }
                return;
            }
            if (chatScriptName == '컴퓨터') {
                printMessage(chat.chat.get(chatScriptName));
                chatScriptName = "";
                window.open("https://www.naver.com", "네이버", "width=500,height=500,top=100,left=100");
                keyDown['f'] = false;
                return;
            }
            if (chatScriptName == '냉장고') {
                item.addItemList('콜라');
                printMessage(chat.chat.get(chatScriptName));
                chatScriptName = "";
                return;
            }


            // console.log(chat.chat.get(chatScriptName));
            printMessage(chat.chat.get(chatScriptName));
            chatScriptName = "";

        } else if (keyDown['i']) {
            if (message.style.opacity == 1) {
                return;
            }
            item.openItemList(message);
        }


        let maxX = canvas.width - this.size;
        let maxY = canvas.height - this.size;
        if (this.x <= 0) this.x = 0;
        if (this.x >= maxX) this.x = maxX;
        if (this.y <= 0) this.y = 0;
        if (this.y >= maxY) this.y = maxY;



        mainObjectList.forEach((obj) => {
            if (obj.collision(player.x, player.y, player.size)) {
                isCrash = true;
                chatScriptName = obj.name;

                switch (obj.name) {
                    case '집입구':
                        currentMapName = '집맵';
                        px = 1000;
                        py = 450;
                        break;
                    case '집출구':
                        currentMapName = '메인맵';
                        px = 485;
                        py = 350;
                        break;
                    case '길건너기입구':
                        currentMapName = '길건너기맵';
                        px = 575;
                        py = 80;
                        break;
                    case '길에서메인으로':
                        currentMapName = '메인맵';
                        px = 485;
                        py = 850 - 80;
                        break;
                    case '자동차':
                        px = 575;
                        py = 80;
                        message.style.opacity = 1;
                        message.innerHTML = '자동차와 부딪쳤다 ! 차를 피해서 나아가자';
                        setTimeout(() => {
                            message.innerHTML = "";
                            message.style.opacity = 0;
                        }, 1000);

                        break;

                    case '길에서농사로':
                        bugCount = 0;
                        mapList[3] = new Map4();
                        currentMapName = '농사맵';

                        px = 575;
                        py = 80;
                        message.style.opacity = 1;
                        message.innerHTML = '벌레로 부터 새싹을 지키자.';
                        setTimeout(() => {
                            message.innerHTML = "";
                            message.style.opacity = 0;
                        }, 1000);
                        break;
                    case '벌레':
                        obj.x = 1300;
                        obj.speed = 0;
                        bugCount += 1;

                        break;
                    case '농사에서길로':

                        currentMapName = '길건너기맵';


                        px = 575;
                        py = 800;

                        break;

                    default:
                        break;
                }


                return false;
            }

        })

        // console.log("test=", isCrash);
        if (isCrash) {
            this.x = px;
            this.y = py;
        }
        // console.log(this.x, ": ", this.y);



    }


    render(ctx) {
        this.movePlayer();
        let playerImg = new Image();
        playerImg.src = this.img;
        ctx.beginPath();
        ctx.fillStyle = this.color;
        ctx.drawImage(playerImg, this.x, this.y, this.size, this.size);
        ctx.fill();
    }

}



let player = new Player();

const bugs = new Bug();
let qkq = null;


function draw() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    ctx.drawImage(backImg, 0, 0, canvas.width, canvas.height);

    mapList.forEach((e) => {
        if (e.name == currentMapName) {
            if (currentMapName == '농사맵') {


                // console.log(e.objectList);

                mainObjectList = [];
                mainObjectList = e.objectList;
                backImg.src = e.backImgName;
                qkq = mainObjectList.find(e => e.name == '정원');
                // console.log(mainObjectList);
                if (bugCount == 5) {
                    qkq.img = 'img/apple2.png';
                }
            } else {
                mainObjectList = [];
                mainObjectList = e.objectList;
                // console.log(mainObjectList);
                backImg.src = e.backImgName;
            }
        }
    })
    player.render(ctx);
    mainRender(ctx, mainObjectList);

}

const c = new Car();
function mainRender(ctx) {


    mainObjectList.forEach((obj) => {

        if (obj.name == '자동차') {
            c.moveCar(obj);
        }
        if (obj.name == '벌레') {
            bugs.moveBug(obj, qkq, message);
        }

        let img = new Image();
        img.src = obj.img;
        ctx.beginPath();
        ctx.drawImage(img, obj.x, obj.y, obj.width, obj.height);
        ctx.fill();


    })

}

function init() {
    player.x = 15;
    player.y = 115;

    message.style.opacity = 1;
    message.innerHTML = `[키설명]<br>
    &nbsp;&nbsp;&nbsp;&nbsp;w s a d : ( 상 하 좌 우 )<br>
    &nbsp;&nbsp;&nbsp;&nbsp;f : 상호작용<br>
    &nbsp;&nbsp;&nbsp;&nbsp;i : 아이템목록`;
    setTimeout(() => {
        message.innerHTML = "";
        message.style.opacity = 0;
    }, 3000);
}

function printMessage(chatScript) {
    if (chatScript == undefined) {
        return;
    }
    message.style.opacity = 1;
    let count = 0;
    let content = `${chatScript}`;
    let msgText = setInterval(() => {
        message.innerHTML += content[count++];
        if (count == content.length) {
            clearInterval(msgText);
            setTimeout(() => {
                message.style.opacity = 0;
            }, 1000);
        };
    }, 100);
    message.innerHTML = "";
}

init();
setInterval(draw, 10);
