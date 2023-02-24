
class Bug {
    constructor(img, name) {
        this.img = img;
        this.name = name;
        this.x = this.addX();
        this.y = Math.random() * 900 + 100;
        this.width = 50;
        this.height = 50;
        this.speed = Math.floor(Math.random() * 1 + 1);
    }


    render(ctx) {
        let objImg = new Image();
        objImg.src = this.img;
        ctx.beginPath();
        // ctx.fillStyle = this.color; 
        ctx.drawImage(objImg, this.x, this.y, this.width, this.height);
        ctx.fill();

    }


    inRect(px, py) {
        if (this.x < px && px < this.x + this.width && this.y < py && py < this.y + this.height) {
            return true;
        } else {
            false;
        }
    }

    collision(px, py, size) {

        if (this.inRect(px, py)) return true;
        // player의 오른쪽 상단 모서리가 닿으면
        else if (this.inRect(px + size, py)) return true;
        // player의 왼쪽 하단 모서리가 닿으면
        else if (this.inRect(px, py + size)) return true;
        // player의 오른쪽 하단 모서리가 닿으면
        else if (this.inRect(px + size, py + size)) return true;
        else return false;

    }

    moveBug(obj, qkq, message) {
        // obj.x = this.addX();

        let dx = qkq.x + qkq.width / 2 - obj.x - obj.width / 2;
        let dy = qkq.y + qkq.height / 2 - obj.y - obj.height / 2;
        let c = Math.sqrt(dx * dx + dy * dy);

        let tdx = dx / c;
        let tdy = dy / c;

        obj.x += tdx * obj.speed;
        obj.y += tdy * obj.speed;

        let a = Math.floor(obj.x);
        let b = Math.floor(obj.y);

        // console.log(a, ":", b);

        if (a >= 580 && a <= 590 && b >= 420 && b <= 430) {
            obj.x = 1300;
            obj.speed = 0;
            qkq.img = 'img/bug.png';
            message.style.opacity = 1;
            message.innerHTML = '지키지 못했다. 다음에 다시 도전해 보자';
            setTimeout(() => {
                message.innerHTML = "";
                message.style.opacity = 0;
            }, 1000);
        }
    }
    addX() {
        const dir = Math.floor(Math.random() * 2);
        let x = 0;
        if (dir == 0) {
            x = 20;
        } else {
            x = 1180;
        }
        return x;
    }

    reBug() {
        let m = new Map4();
        for (let i = 0; i < m.objectList.length; i++) {

            if (m.objectList[i].name == '벌레') {
                m.objectList.splice(i, 1);
                i--;

            }
        }
        console.log(m.objectList);


    }

    testBug() {
        let m = new Map4();
        m.objectList.push(new Bug('img/bug.png', '벌레'));
        m.objectList.push(new Bug('img/bug.png', '벌레'));
        m.objectList.push(new Bug('img/bug.png', '벌레'));
        m.objectList.push(new Bug('img/bug.png', '벌레'));
        m.objectList.push(new Bug('img/bug.png', '벌레'));
        console.log(m.objectList);
    }

}


