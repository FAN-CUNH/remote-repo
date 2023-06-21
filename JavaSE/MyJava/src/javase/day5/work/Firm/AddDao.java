package javase.day5.work.Firm;

public class AddDao implements AddInterface {
    @Override
    public void addWage(Person person) {
        if (person instanceof Manager){ // 子类instanceof父类 = true；父类instanceof子类 = false；
            ((Manager) person).setWage(((Manager) person).getWage()*1.2);
        }
        else {
            ((Employee) person).setWage(((Employee) person).getWage()*1.1);
        }
    }
}
