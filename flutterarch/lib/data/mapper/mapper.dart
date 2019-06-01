export 'package:flutter_architecture/data/mapper/post_mapper.dart';

abstract class Convert<T, P> {
  P fromSourceModel(T fromModel);
}