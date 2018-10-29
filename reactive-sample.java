Observable.just(1, 2, 3, 4, 5, 6)
  .filter(integer -> integer % 2 == 0)
  .subscribe(System.out::println)
