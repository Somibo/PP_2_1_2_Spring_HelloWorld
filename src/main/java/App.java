import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) { // [ВИДНО НАЗВАНИЕ БИНОВ!]
            System.out.println(beanDefinitionName);
        }
        HelloWorld bean =
                (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean.getMessage());

        HelloWorld bean2 = applicationContext.getBean("helloworld", HelloWorld.class);

        Cat kot1 = applicationContext.getBean("Cat", Cat.class);
        Cat kot2 = applicationContext.getBean("Cat", Cat.class);

        System.out.println(bean == bean2);
        System.out.println(kot1 == kot2);
    }
}