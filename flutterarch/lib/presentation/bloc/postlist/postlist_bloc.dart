import 'package:bloc/bloc.dart';
import 'package:rxdart/rxdart.dart';

import 'package:flutter_architecture/injection/dependency_injection.dart';
import 'package:flutter_architecture/domain/usecase/usecase.dart';


import 'package:flutter_architecture/presentation/bloc/postlist/postlist.dart';


class PostBloc extends Bloc<PostEvent, PostState> {

  @override
  Stream<PostEvent> transform(Stream<PostEvent> events) {
    return (events as Observable<PostEvent>)
        .debounce(Duration(milliseconds: 500));
  }

  @override
  PostState get initialState => PostUninitialized();

  @override
  Stream<PostState> mapEventToState(PostState currentState, PostEvent event) async* {

    if(event is Fetch){
      try{
        if (currentState is PostUninitialized) {
          var posts = await new FetchPostsUseCase(Injector.providePostRepository()).fetchPosts();
          yield PostLoaded(posts);
        }
      } catch(_){
        yield PostError();
      }
    }
  }



}