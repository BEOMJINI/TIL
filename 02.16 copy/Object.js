
class Object {
    constructor(img, name, x, y, width, height) {
        this.img = img;
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        // this.color = color;
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

        else if (this.inRect(px + size, py)) return true;

        else if (this.inRect(px, py + size)) return true;

        else if (this.inRect(px + size, py + size)) return true;
        else return false;

    }



}