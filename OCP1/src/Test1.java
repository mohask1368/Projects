import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserPrincipal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;

class Test1 {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException, IOException, ExecutionException {

//        List<Integer> integers = new ArrayList<>();
//        integers.add(20);
//        integers.add(10);
//        integers.add(40);
//        System.out.println(integers);
//        Consumer<List<Integer>> methodRef1 = Collections::sort;
//        methodRef1.accept(integers);
//        System.out.println(integers);
//
//
//        String str = "abc";
//         Predicate<String> methodRef2 = str::startsWith;
//         Predicate<String> lambda2 = s -> str.startsWith(s);
//
//        System.out.println(methodRef2.test("a"));
//        System.out.println(lambda2.test("a"));
////
//        Supplier<ArrayList> methodRef4 = ArrayList::new;
//        methodRef4.get().add("hello");
//        System.out.println(methodRef4.get().size());

//        List<String> list = new ArrayList<>();
//         list.add("Magician");
//         list.add("Assistant");
//         System.out.println(list); // [Magician, Assistant]
//         list.removeIf(s -> s.startsWith("A"));
//         System.out.println(list); // [Magician]

//        BiFunction<String, String, String> mapper = (v1, v2)  -> v1.length() > v2.length() ? v1: v2;
//
//         Map<String, String> favorites = new HashMap<>();
//         favorites.put("Jenny", "Bus Tour");
//         favorites.put("Tom", "Tram");
//
//         String jenny = favorites.merge("Jenny", "Skyride", mapper);
//         String tom = favorites.merge("Tom", "Skyride", mapper);
//
//         System.out.println(favorites);
//         System.out.println(jenny);
//         System.out.println(tom);

//        Supplier<ArrayList<String>> s1 = ArrayList<String>::new;
//        ArrayList<String> a1 = s1.get();
//
//        System.out.println(a1);

//        Consumer<String> c1 = System.out::println;
//        Consumer<String> c2 = x -> System.out.println(x);
//        c1.accept("Annie");
//        c2.accept("Annie");

//        Map<Integer, Integer> map = new HashMap<>();
//        BiConsumer<Integer, Integer> b1 = map::put;
//        BiConsumer<Integer, Integer> b2 = (k, v) -> map.put(k, v);
//        b1.accept(1, 7);
//        b2.accept(2, 1);
//        System.out.println(map);

//        BiPredicate<Integer,Integer> p = Integer::equals;
//        BiPredicate<Integer,Integer> p2 = (x,y)->x.equals(y);
//        System.out.println(p2.test(2,5));

//        BinaryOperator<String> b1 = String::concat;
//        BinaryOperator<String> b2 = (string, toAdd) -> string.concat(toAdd);
//
//        Stream<String> empty = Stream.empty();
//        Stream<Integer> singleElement = Stream.of(1);
//        Stream<Integer> fromArray = Stream.of(1, 2, 3);
//        System.out.println(empty.count());
//        System.out.println(singleElement.count());
//        System.out.println(fromArray.count());

//        Stream<Double> randoms = Stream.generate(Math::random);
//        randoms.limit(10).forEach(System.out::println);
//         Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
//        oddNumbers.forEach(System.out::println);

//        Stream<String> s = Stream.of("monkey", "ape", "bonobo");
//        Optional<String> min = s.min((s1, s2) -> s1.length()-s2.length());
//        min.ifPresent(System.out::println); // ape

//        Stream<Integer> infinite = Stream.iterate(1,a->  a+1);
//        infinite.limit(10).forEach(System.out::println);

//        List<String> list = Arrays.asList("m", "n", "1");
//        Predicate<String> pred = x -> Character.isDigit(x.charAt(0));
//        System.out.println(list.stream().anyMatch(pred));
//        System.out.println(list.stream().allMatch(pred));
//        System.out.println(list.stream().noneMatch(pred));

//        Stream<String> stream = Stream.of("w", "o", "l", "f");
//        String word = stream.reduce("", (s, c) -> s + c);
//        System.out.println(word); // wolf

//        Stream<Integer> stream = Stream.of(3, 5, 6);
//        System.out.println(stream.reduce(1, (a, b) -> a*b));

//        BinaryOperator<Integer> op = (a, b) -> a * b;
//        Stream<Integer> stream = Stream.of(3, 5, 6);
//        System.out.println(stream.reduce(1, op)); // 90
//
//        Stream<String> s = Stream.of("duck", "duck", "duck", "goose");
//        s.distinct().forEach(System.out::print); // duckgoose

//        Stream<Integer> s = Stream.iterate(1, n -> n + 1);
//        s.skip(5).limit(4).forEach(System.out::print);

//        Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
//        infinite.limit(5)
//                .peek(System.out::print)
//                .filter(x -> x % 2 == 1)
//                .forEach(System.out::print);

//        IntStream stream = IntStream.rangeClosed(1,10);
//        OptionalDouble optional = stream.average();
//        optional.ifPresent(System.out::println);
//        System.out.println(optional.getAsDouble());
//        System.out.println(optional.orElseGet(() -> Double.NaN));

//        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
//        Double result = ohMy.collect(Collectors.averagingInt(String::length));
//        System.out.println(result); // 5.333333333333333



//        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
//        TreeMap<Integer, Set<String>> map = ohMy.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
//        System.out.println(map); // {5=[lions, bears], 6=[tigers]}


//        String text = "Ali#and#Taghi#are#friends";
//        String[] array = text.replace('#', '!').split("!");
//        int sum=0;
//        for (String s : array)
//            sum+=s.length();
//        System.out.println(sum);

//        double d = 3.54454d;
//        System.out.format("number = %.3f",d);

//        int i = 1;
//        int j = 2;
//        System.out.println(i/j);
//
//        Integer m = new Integer("5");
//        Integer n = new Integer(5);
//        System.out.println(m.equals(n));

//        System.out.println(LocalDate.now());
//        System.out.println(LocalTime.now());
//        System.out.println(LocalDateTime.now());
//        System.out.println(ZonedDateTime.now());

//        System.out.println(ZoneId.systemDefault());
//        ZoneId.getAvailableZoneIds().stream().sorted().forEach(System.out::println);

//        List<Object> list = new ArrayList();
//        list.addAll(ZoneId.getAvailableZoneIds());
//
//        for (Object s:
//             list) {
//            System.out.println(s);
//        }

//        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
//        date = date.plusDays(5);
//        Duration duration = Duration.ofSeconds(3600);
//        System.out.println(duration);

//
//        Locale locale = Locale.getDefault();
//        System.out.println(locale);

//        System.out.println(new Locale("ma","as"));


//        ResourceBundle resourceBundle = ResourceBundle.getBundle("file");
//        Set<String> set = resourceBundle.keySet();
//        set.stream().map(k->k+" "+resourceBundle.getString(k)).forEach(System.out::println);

//        System.out.println(NumberFormat.getCurrencyInstance().format(10));
//
//        double price = 48;
//        NumberFormat us = NumberFormat.getCurrencyInstance();
//        NumberFormat fa = NumberFormat.getCurrencyInstance(new Locale("fa","IR"));
//        System.out.println(us.format(price));
//        System.out.println(fa.format(price));
//
//        String[] locale = Locale.getISOCountries();
//        for (String s:locale) {
//            System.out.println(s);
//        }
//
//        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
//        LocalTime time = LocalTime.of(11, 12, 34);
//        LocalDateTime dateTime = LocalDateTime.of(date, time);
//        System.out.println(date.format(DateTimeFormatter.ISO_DATE));
//        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
//        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

//        ExecutorService service =  Executors.newSingleThreadExecutor();
//        Future<?> future = service.submit(() -> System.out.println("Hello Zoo"));
//        System.out.println(future.isDone());
//        Thread.sleep(1000);
//        System.out.println(future.isDone());

//        System.out.println(Runtime.getRuntime().availableProcessors());

//        Map<String, Object> foodData = new ConcurrentHashMap<String, Object>();
//        foodData.put("penguin", 1);
//        foodData.put("flamingo", 2);
//        for(String key: foodData.keySet())
//            foodData.remove(key);
//        System.out.println(foodData.size());

//        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
//        queue.offer(31);
//        queue.offer(26);
//        System.out.println(queue.peek());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());

//        Deque<Integer> deque = new ConcurrentLinkedDeque<>();
//        deque.offer(10);
//        deque.push(4);
//        System.out.println(deque.getLast());
//        System.out.println(deque.peek());
//        System.out.println(deque.pop());

//        try {
//            BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
//            blockingQueue.offer(39);
//            blockingQueue.offer(3, 4, TimeUnit.SECONDS);
//            System.out.println(blockingQueue.poll());
//            System.out.println(blockingQueue.poll(10, TimeUnit.MILLISECONDS));
//        } catch (InterruptedException e) {
//// Handle interruption
//        }

//        Stream<Integer> stream = Arrays.asList(1,2,3,4,5,6).parallelStream();
//
//        System.out.print(Arrays.asList(1,2,3,4,5,6).parallelStream().findFirst().get());


//        Arrays.asList(1,2,3,4,5,6).parallelStream().unordered().skip(3).forEach(System.out::println);

//        System.out.println(Arrays.asList('w', 'o', 'l', 'f').parallelStream().reduce("",(c,s1) -> c + s1, (s2,s3) -> s2 + s3));

//        System.out.println(Arrays.asList("w","o","l","f")
//                .stream()
//                .reduce("x",String::concat));


//        Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
//        Set<String> set = stream.collect(Collectors.toSet());
//        System.out.println(set);

//        Stream<String> ohMy = Stream.of("lions", "tigers", "bears").parallel();
//        ConcurrentMap<Integer, String> map = ohMy.collect(Collectors.toConcurrentMap(String::length, k -> k, (s1, s2) -> s1 + "," + s2));
//        System.out.println(map); // {5=lions,bears, 6=tigers}
//        System.out.println(map.getClass()); // java.util.concurrent.ConcurrentHashMap

//        System.out.println(File.separator);
//        System.out.println(System.getProperty("file.separator"));

//        File file = new File("c:\\users\\MAM\\Desktop\\test.txt");
//        System.out.println(file.exists());

//        File file = new File("c:\\users\\MAM\\Desktop\\salam");
//        file.mkdir();
//
//        InputStream is = new BufferedInputStream(new FileInputStream("c:\\users\\MAM\\Desktop\\test.txt"));
//        System.out.print ((char)is.read());
//        if(is.markSupported()) {
//            is.mark(100);
//            System.out.print((char)is.read());
//            System.out.print((char)is.read());
//            is.reset();
//        }
//        System.out.print((char)is.read());
//        System.out.print((char)is.read());
//        System.out.print((char)is.read());

//        InputStream is = new BufferedInputStream(new FileInputStream("c:\\users\\MAM\\Desktop\\test.txt"));
//        System.out.print ((char)is.read());
//        is.skip(2);
//        is.read();
//        System.out.print((char)is.read());
//        System.out.print((char)is.read());

//        PrintWriter out = new PrintWriter("c:\\users\\MAM\\Desktop\\test.txt");
//
//        out.print("a"); // PrintWriter method
//        out.write("b"); // Writer method
//        out.print("c"); // PrintWriter method
//        out.format("0");
//        out.write("d"); // Writer method
//        out.flush();

//        Console console = System.console();
//        console.writer().format(new Locale("fr", "CA"),"Hello World");

//        System.out.println(Paths.get("/stripes/zebra.exe").isAbsolute());
//        System.out.println(Paths.get("c:/goats/Food.java").isAbsolute());

//        Path path = Paths.get("/mammal/carnivore/raccoon.image");
//        System.out.println("Path is: "+path);
//        System.out.println("Subpath from 0 to 3 is: "+path.subpath(0,3));
//        System.out.println("Subpath from 1 to 3 is: "+path.subpath(1,3));
//        System.out.println("Subpath from 1 to 2 is: "+path.subpath(1,2));


//        final Path path1 = Paths.get("/cats/../panther");
//        final Path path2 = Paths.get("food");
//                System.out.println(path1.isAbsolute());
//                System.out.println(path2.isAbsolute());
//
//        System.out.println(path1.resolve(path2));

//        final Path path1 = Paths.get("/turkey/food");
//        final Path path2 = Paths.get("/tiger/cage");
//        System.out.println(path1.isAbsolute());
//        System.out.println(path2.isAbsolute());
//        System.out.println(path1.resolve(path2));
//        System.out.println(path2.resolve(path1));

//        Files.createDirectories(Paths.get("c:\\users\\MAM\\Desktop\\gooz\\chos"));
//        Files.createDirectories(Paths.get("/bison/field/pasture/green"));

//       Files.delete(Paths.get("c:\\users\\MAM\\Desktop\\2"));

//        System.out.println(Files.getOwner(Paths.get("c:\\users\\MAM\\Desktop")).getName());

//            Comparator<Person> comparator =  (p1,p2) -> p1.getName().compareTo(p2.getName());
//            Person p1 = new Person("ali");
//            Person p2 = new Person("hasan");
//
//            int i = comparator.compare(p1,p2);
//        System.out.println(i);
//
//        List<? extends Number> list1 = new ArrayList<>(); //upper bound
//        list1.add(new Integer(1));
//        list1.add(new Double(2));
//        list1.add(new Float(2.0));
//        list1.add(new Object());
//
//        List<? super Number> list2 = new ArrayList<>(); //lower bound
//        list2.add(new Integer(1));
//        list2.add(new Double(2));
//        list2.add(new Float(2.0));
//        list2.add(new Object());

//        Set<Integer> set = new TreeSet<>();
//         boolean b1 = set.add(66); // true
//         boolean b2 = set.add(10); // true
//         boolean b3 = set.add(66); // false
//         boolean b4 = set.add(8); // true
//         for (Integer integer: set) System.out.print(integer + ","); // 8,10,66



//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(1, 10);
//        map.put(2, 20);
//        map.put(3, null);
//        map.merge(1, 3, (a,b) -> a + b);
//        map.merge(3, 3, (a,b) -> a + b);
//        System.out.println(map);

//
//        Optional<Double> opt = Optional.empty();
//        System.out.println(opt.orElse(0D));
//        System.out.println(opt.orElseGet(() -> new Double(1)));


//        IntPredicate intPredicate = (a)->a>5;
//        System.out.println(intPredicate.test(1));

//        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
//        Set result = ohMy.collect(Collectors.toSet());
//        System.out.println(result);

//        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
//        Map<String, Integer> map = ohMy.collect(
//                Collectors.toMap(s -> s, String::length));
//        System.out.println(map); // {lions=5, bears=5, tigers=6}


//        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
//        Map<Integer, String> map = ohMy.collect(Collectors.toMap(String::length, k -> k, (s1, s2) -> s1 + "," + s2));
//        System.out.println(map); // {5=lions,bears, 6=tigers}
//        System.out.println(map.getClass()); // class. java.util.HashMap

//        IntStream is = IntStream.of(2,3);
//        OptionalInt any = is.findAny();
//        System.out.println(any);

//        DoubleStream s = DoubleStream.of(1.2, 2.4);
//        long count = s.peek(System.out::println).filter(x -> x > 2).count();
//        System.out.println(count);

//        ZoneId iran = ZoneId.of("Iran");
//        System.out.println(iran);



//        ZonedDateTime zonedDateTime = ZonedDateTime.now();
//        System.out.println(zonedDateTime);
//        Instant instant = zonedDateTime.toInstant();
//        System.out.println(instant);


//        Locale locale = Locale.getDefault();
//        System.out.println(locale);
//        locale.setDefault(new Locale("fr","IR"));
//        System.out.println(Locale.getDefault());


//        NumberFormat instance = NumberFormat.getIntegerInstance(new Locale("fr","IR"));
//        String format = instance.format(1.4);
//        System.out.println(format);


//        int a=1;
//        assert a>2 :"kkhhkkhhk";
//        System.out.println("hast");


//        ScheduledExecutorService service = null;
//        Runnable task1 = () -> System.out.println("Hello Zoo");
//        try {
//            service = Executors.newSingleThreadScheduledExecutor();
//            ScheduledFuture<?> result = service.schedule(task1, 5, TimeUnit.SECONDS);;
//            System.out.println(result.get());
//        } finally {
//            if(service != null) service.shutdown();
//        }


//        AtomicLong value1 = new AtomicLong(0);
//        IntStream.iterate(1, i -> 1).limit(100).parallel().forEach(i -> value1.incrementAndGet());
//        System.out.println(value1);

//        System.out.println(Arrays.asList("duck","chicken","flamingo","pelican")
//                .parallelStream().parallel()
//                .reduce("", (c1, c2) -> c1 + c2.length(),(s1, s2) -> s1 + s2));

//        PrintWriter out = new PrintWriter("c:\\users\\MAM\\Desktop\\1.txt");
//        out.println("26");
//        out.print(5);
//        out.flush();

//        PrintStream printStream = new PrintStream("c:\\users\\MAM\\Desktop\\1.txt");
//        printStream.println("11");





//    int i;
//    FileReader fileReader = new FileReader("c:\\users\\MAM\\Desktop\\3.txt");
//    while ((i=fileReader.read()) != -1)
//        System.out.print((char) i);


//        Path path = Paths.get("c:\\users\\MAM\\Desktop\\3.txt");
//        System.out.println("Filename is: "+path.getFileName());
//        System.out.println("Root is: "+path.getRoot());


//        System.out.println(Paths.get("/stripes/zebra.exe").isAbsolute());
//        System.out.println(Paths.get("c:/goats/Food.java").isAbsolute());


//        System.out.println(Paths.get(".").toRealPath());


//        Files.delete(Paths.get("c:\\users\\MAM\\Desktop\\3.txt"));

//        System.out.println(Files.exists(Paths.get("c:\\users\\MAM\\Desktop\\1.txt")));
//        System.out.println(Files.isHidden(Paths.get("c:\\users\\MAM\\Desktop\\1.txt")));
//        System.out.println(Files.isReadable(Paths.get("c:\\users\\MAM\\Desktop\\1.txt")));
//        System.out.println(Files.isExecutable(Paths.get("c:\\users\\MAM\\Desktop\\1.txt")));
//        System.out.println(Files.size(Paths.get("c:\\users\\MAM\\Desktop\\1.txt")));
//        System.out.println(Files.getOwner(Paths.get("c:\\users\\MAM\\Desktop\\1.txt")));
//            Path path = Paths.get("c:\\users\\MAM\\Desktop\\1.txt");
//       UserPrincipal owner = path.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("mam");
//
//        Files.setOwner(path, owner);
//
//       System.out.println(Files.getOwner(Paths.get("c:\\users\\MAM\\Desktop\\1.txt")));

//        long dateFilter = 1420070400000l;
//        Stream<Path> stream = Files.find(path, 10, (p,a) -> p.toString().endsWith(".java") && a.lastModifiedTime().toMillis()>dateFilter);
//        stream.forEach(System.out::println);



//        Path path = Paths.get("/zoo/animals/bear/koala/food.txt");
//        System.out.println(path.subpath(3,4));
//
//        Path path1 = Paths.get("/lizard/./").resolve(Paths.get("walking.txt"));
//        Path path2 = new File("/lizard/././actions/../walking.txt").toPath();
//        System.out.println(path1.normalize());
//        System.out.println(path2.normalize());


//        List<Integer> list = new ArrayList<>();
//        List<Integer> list2 = new ArrayList<>();
//
//        for(int i=0;i<=799;i++){
//            list.add(i);
//        }
//
//        Random randomizer = new Random();
//        for (Integer j=0;j<=79;j++) {
//            Integer random = list.get(randomizer.nextInt(list.size()));
//            list2.add(random);
//        }



//        final String s = String.valueOf(26);

//        List<Integer> integers = new Vector<>();


//        BiConsumer<String,Integer> biConsumer = (s,i)->  System.out.print(s+i);
//        biConsumer.accept("Mohammad ",26);

//        List<String> list = Arrays.asList("a", "b", "c");
//        list.stream().forEach(s -> System.out.print(s));
//        list.stream().forEach(System.out::print);

//        Instant now = Instant.now();
//        LocalTime localTime = LocalTime.now();
//        System.out.println(now);
//        System.out.println(localTime);

//        ExecutorService service = Executors.newSingleThreadExecutor();
//        Future<?> submit = service.submit(() -> System.out.println("2"));

//
//
//        Callable callable = () -> 30 + 11;
//        Future<Integer> submit1 = service.submit(callable);
//
//        Object o = submit.get();
//        Integer integer = submit1.get();
//        System.out.println(o);
//
//        System.out.println(Arrays.asList('w', 'o', 'l', 'f')
//                .stream()
//                .reduce("",(c,s1) -> c + s1, (s2,s3) -> s2 + s3));

//        Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
//        SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);
//        System.out.println(set);



//        Path source = Paths.get("E:\\3.txt");
//        Path des = Paths.get("H:\\");
//        if (Files.exists(source)&&(Files.exists(des)))
//        Files.copy(source,des);


//        BasicFileAttributeView view =
//                Files.getFileAttributeView(source,BasicFileAttributeView.class);
//        BasicFileAttributes data = view.readAttributes();

//        Files.walk(Paths.get("c:\\users\\MAM\\Desktop")).forEach(System.out::println);






    }
}


