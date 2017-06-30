package mdnov.cn.xml.service;

import android.content.Context;
import android.content.res.AssetManager;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import mdnov.cn.xml.domain.Person;

/**
 * Created by Administrator on 2017/6/25.
 */
public class PersonService {
    private Context context;

    public PersonService(Context context) {

        this.context = context;
    }

    public List<Person> getPersons() throws XmlPullParserException, IOException {
        AssetManager manager=context.getAssets();
        InputStream is = manager.open("person.xml");
        ArrayList<Person> persons=null;
        Person person=null;
        // 创建一个xml解析的工厂
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        // 获得xml解析类的引用
        XmlPullParser parser = factory.newPullParser();
        parser.setInput(is,"utf-8");
        int type=parser.getEventType();
        while(type!=XmlPullParser.END_DOCUMENT){
            switch (type){
                case XmlPullParser.START_TAG:
                    if("persons".equals(parser.getName())){
                        persons = new ArrayList<Person>();
                    }else if("person".equals(parser.getName())){
                        person=new Person();
                    }else if("name".equals(parser.getName())){
                        person.setName(parser.nextText());
                    }else if("age".equals(parser.getName())){
                        person.setAge(Integer.parseInt(parser.nextText()));
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if("person".equals(parser.getName())){
                        persons.add(person);
                    }
                    break;
            }
            type=parser.next();
        }
        return persons;

    }
}
