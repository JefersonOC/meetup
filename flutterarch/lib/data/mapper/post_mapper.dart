import 'package:flutter_architecture/data/model/model.dart';
import 'package:flutter_architecture/presentation/model/model.dart';

class PostMapper {

  static List<Post> transform(List<RemotePost> resultSource) {
    List<Post> resultList = new List<Post>();
    if (resultSource != null) {
    resultSource.forEach((u) => resultList.add(new Post(u)));
    }
    return resultList;
  }

}