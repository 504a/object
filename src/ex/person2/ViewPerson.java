package ex.person2;

import sample.enumsample.Gender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ViewPerson {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>(15);
        Map<Birthplace,List<Person>> birthplacePersonMap = new HashMap<>();

        //人物追加
        personList.addAll(Arrays.asList(
                    new Person("やまだ",Birthplace.HOKKAIDO,Gender.MEN,35),
                    new Person("いけだ",Birthplace.HOKKAIDO,Gender.WOMEN,26),
                    new Person("いのうえ",Birthplace.FUKUOKA,Gender.MEN,32),
                    new Person("たむら",Birthplace.FUKUOKA,Gender.WOMEN,22),
                    new Person("わだ",Birthplace.TOKYO,Gender.MEN,42),
                    new Person("くどう",Birthplace.TOKYO,Gender.WOMEN,55),
                    new Person("さらど",Birthplace.OSAKA,Gender.MEN,31),
                    new Person("あいざわ",Birthplace.OSAKA,Gender.WOMEN,44)
                ));

        //出身地ごとの分類してマップにする
        for (Person person:personList) {
            if (birthplacePersonMap.containsKey(person.getBirthplace())) {
                birthplacePersonMap.get(person.getBirthplace()).add(person);
            } else {
                List<Person> list = new ArrayList<>();
                list.add(person);
                birthplacePersonMap.put(person.getBirthplace(),list);
            }
        }

        //分類できたか表示
        for (Map.Entry entry:birthplacePersonMap.entrySet()) {
            System.out.println(entry.getKey());
            for (Person person:(List<Person>)entry.getValue())
                System.out.println(person);
        }

        //平均年齢の算出
        double ageSum = 0;//年齢の合計
        double cnt = 0 ;//人数
        for (Map.Entry entry:birthplacePersonMap.entrySet()) {
            System.out.print(((Birthplace)entry.getKey()).getName());
            ageSum = 0;//クリア
            cnt = 0;//クリア
            for (Person person:(List<Person>)entry.getValue()) {
                ageSum += person.getAge();
                cnt++;
            }
            System.out.println(String.format(":%.1f歳",ageSum / cnt));
        }

        //男女別平均年齢の算出
        double ageMenSum = 0,ageWomenSum = 0,menCnt = 0,womenCnt = 0;
        for (Map.Entry entry:birthplacePersonMap.entrySet()) {
            System.out.println(((Birthplace)entry.getKey()).getName());
            for (Person person:(List<Person>)entry.getValue()) {
                ageMenSum = 0;
                ageWomenSum = 0;
                menCnt = 0;
                womenCnt = 0;
                if (person.getGender().equals(Gender.MEN)) {
                    ageMenSum += person.getAge();
                    menCnt++;
                } else {
                    ageWomenSum += person.getAge();
                    womenCnt++;
                }
                ageSum += person.getAge();
            }
            System.out.println(String.format("男性:%.1f歳",(ageMenSum / menCnt)));
            System.out.println(String.format("女性:%.1f歳",(ageWomenSum / womenCnt)));
        }
    }
}
