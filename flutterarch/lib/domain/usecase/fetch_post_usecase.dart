import 'dart:async';

import 'package:flutter_architecture/data/repository/repository.dart';
import 'package:flutter_architecture/presentation/model/model.dart';

class FetchPostsUseCase {
  PostRepository postRepository;

  FetchPostsUseCase(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  Future<List<Post>> fetchPosts() async {
   return await postRepository.fetchPosts();
  }
}