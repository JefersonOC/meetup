import 'package:equatable/equatable.dart';

import 'package:flutter_architecture/presentation/model/model.dart';

abstract class PostState extends Equatable {
  PostState([List props = const []]) : super(props);
}

class PostUninitialized extends PostState {
  @override
  String toString() => "PostUninitialized";
}

class PostError extends PostState {
  @override
  String toString() => "PostError";
}

class PostLoaded extends PostState {
  final List<Post> posts;

  PostLoaded(this.posts) : super(posts);

  PostLoaded copyWith({
    List<Post> posts,
  }){
    return PostLoaded(posts ?? this.posts);
  }
}
