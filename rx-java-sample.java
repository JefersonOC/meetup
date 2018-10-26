private final CompositeDisposable disposables = new CompositeDisposable();

// adding an Observable to the disposable
disposables.add(sampleObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<String>() {
                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(String value) {
                    }
                }));

    static Observable<String> sampleObservable() {
        return Observable.defer(new Callable<ObservableSource<? extends String>>() {
            @Override
            public ObservableSource<? extends String> call() throws Exception {
                // Do some long running operation
                SystemClock.sleep(2000);
                return Observable.just("one", "two", "three", "four", "five");
            }
        });
    }                


// Using clear will clear all, but can accept new disposable
disposables.clear(); 
// Using dispose will clear all and set isDisposed = true, so it will not accept any new disposable
disposables.dispose(); 
