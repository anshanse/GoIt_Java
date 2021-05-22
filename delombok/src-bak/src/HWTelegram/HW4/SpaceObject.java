package HWTelegram.HW4;

abstract public class SpaceObject {

}

abstract class Planet extends SpaceObject{

}

class Mars extends Planet{

}

class Moon extends SpaceObject{

}

class PlanetTester{
    public String test(SpaceObject object){
        if (object instanceof Planet) return "planet";
        else return "not planet";
    }
}