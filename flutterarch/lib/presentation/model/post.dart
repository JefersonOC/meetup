import 'package:flutter_architecture/data/model/remote_post.dart';
import 'package:flutter_architecture/data/mapper/mapper.dart';

class Post implements Convert<RemotePost, Post> {

  int userId;
  int id;
  String title;
  String body;

  Post(RemotePost fromModel) {
    userId = fromModel.userId;
    id = fromModel.id;
    title = fromModel.title;
    body = fromModel.body;
  }

  @override
  Post fromSourceModel(RemotePost fromModel) {
    return new Post(fromModel);
  }


}