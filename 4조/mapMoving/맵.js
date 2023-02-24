class Map1 {
    constructor() {
        this.name = '메인맵';
        this.objectList = [];
        this.init();
        this.backImgName = 'img/test1.jpg';
    }

    init() {
        this.objectList.push(new Object('', '바다', 0, 190, 90, 320));
        this.objectList.push(new Object('', '바다', 90, 240, 90, 300));
        this.objectList.push(new Object('', '바다', 180, 290, 130, 140));
        this.objectList.push(new Object('', '풍차', 145, 710, 100, 50));
        this.objectList.push(new Object('', '풍차', 350, 530, 100, 50));
        this.objectList.push(new Object('', '풍차', 410, 710, 100, 50));
        this.objectList.push(new Object('', '풍차', 600, 605, 100, 50));
        this.objectList.push(new Object('', '풍차', 705, 565, 100, 50));
        this.objectList.push(new Object('', '나무', 290, 630, 70, 150));
        this.objectList.push(new Object('', '나무', 625, 420, 70, 150));
        this.objectList.push(new Object('', '숲', 0, 10, 420, 60));
        this.objectList.push(new Object('', '숲', 90, 85, 380, 40));
        this.objectList.push(new Object('', '숲', 305, 150, 120, 60));
        this.objectList.push(new Object('', '숲', 410, 210, 50, 120));
        this.objectList.push(new Object('', '숲', 790, 350, 120, 200));
        this.objectList.push(new Object('', '숲', 0, 830, 470, 50));
        this.objectList.push(new Object('', '숲', 570, 830, 500, 50));
        this.objectList.push(new Object('', '숲', 1000, 740, 50, 70));
        this.objectList.push(new Object('', '집', 550, 190, 250, 150));
        this.objectList.push(new Object('', '학원', 790, 640, 50, 70));
        this.objectList.push(new Object('', '학원', 920, 640, 100, 70));
        this.objectList.push(new Object('img/ArrowUp.png', '집입구', 485, 250, 50, 50));
        this.objectList.push(new Object('', '학원입구', 855, 655, 50, 50));
        this.objectList.push(new Object('img/ArrowDown.png', '길건너기입구', 485, 850, 50, 50));

    }
}

class Map2 {
    constructor() {
        this.name = '학원맵';
        this.objectList = [];
        this.init();
        this.backImgName = 'img/dumy.png';
    }

    init() {
        this.objectList.push(new Object('img/check.png', '책상', 230, 670, 150, 100));
        this.objectList.push(new Object('img/check.png', '책상', 230, 470, 150, 100));
        this.objectList.push(new Object('img/check.png', '책상', 230, 270, 150, 100));
        this.objectList.push(new Object('img/check.png', '책상', 730, 270, 150, 100));
        this.objectList.push(new Object('img/check.png', '책상', 730, 470, 150, 100));
        this.objectList.push(new Object('img/check.png', '책상', 730, 670, 150, 100));
        this.objectList.push(new Object('img/check.png', '책상', 840, 95, 150, 100));
        this.objectList.push(new Object('img/bug.png', '학원출구', 595, 805, 50, 50));
    }
}

class Map3 {
    constructor() {
        this.name = '길건너기맵';
        this.objectList = [];
        this.init();
        this.backImgName = 'img/road2.png';
    }

    init() {
        this.objectList.push(new Object('img/ArrowUp.png', '길에서메인으로', 575, 0, 50, 50));
        this.objectList.push(new Car('img/carblue.png', '자동차', 0, 250, 150));
        this.objectList.push(new Car('img/carred.png', '자동차', 1200, 325, 150));
        this.objectList.push(new Car('img/carblue.png', '자동차', 200, 400, 150));
        this.objectList.push(new Car('img/carred.png', '자동차', 1200, 475, 150));
        this.objectList.push(new Car('img/carbrown.png', '자동차', 0, 550, 150));
        this.objectList.push(new Car('img/carred.png', '자동차', 900, 625, 150));
        this.objectList.push(new Car('img/carbrown.png', '자동차', 0, 700, 150));
        this.objectList.push(new Object('img/ArrowDown.png', '길에서농사로', 575, 850, 50, 50));
        this.objectList.push(new Object('img/forest.png', '벽', -30, -30, 500, 200));
        this.objectList.push(new Object('img/forest.png', '벽', 700, -30, 500, 200));
        this.objectList.push(new Object('', '벽', 0, 850, 500, 50));
        this.objectList.push(new Object('', '벽', 680, 850, 520, 50));
    }
}

class Map4 {
    constructor() {
        this.name = '농사맵';
        this.objectList = [];
        this.init();
        this.backImgName = 'img/gardenmap2.png';
    }

    init() {
        this.objectList.push(new Object('img/ArrowUp.png', '농사에서길로', 575, 0, 50, 50));
        this.objectList.push(new Object('img/apple1.png', '정원', 510, canvas.height / 2 - 100, 200, 200));

        this.objectList.push(new Bug('img/bug.png', '벌레'));
        this.objectList.push(new Bug('img/bug.png', '벌레'));
        this.objectList.push(new Bug('img/bug.png', '벌레'));
        this.objectList.push(new Bug('img/bug.png', '벌레'));
        this.objectList.push(new Bug('img/bug.png', '벌레'));

    }
}

class Map5 {
    constructor() {
        this.name = '집맵';
        this.objectList = [];
        this.init();
        this.backImgName = 'img/house2.png';
    }

    init() {
        this.objectList.push(new Object('img/computer.png', '컴퓨터', 450, 20, 200, 200));
        this.objectList.push(new Object('img/ice.png', '냉장고', 750, 20, 200, 200));
        this.objectList.push(new Object('img/ArrowRight.png', '집출구', 1120, 450, 50, 50));
    }
}

class Map6 {
    constructor() {
        this.name = '낚시맵';
        this.objectList = [];
        this.init();
        this.backImgName = 'img/dumy.png';
    }

    init() {

    }
}
