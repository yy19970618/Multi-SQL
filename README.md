# Multi-SQL: An extensible multi-model data query language
Multi-SQL is the first query language based on various data models.  Multi-SQL can also be expanded to suit more complicated scenarios as it is flexible to support other data models. Moreover, we provide a formal semantic definition of the core features of Multi-SQL, including the multi-model definition, multi-model filters, multi-model joins, etc. Furthermore, we propose a two-level query implementation method to totally exploit the existing query optimization capabilities of the underlying engines which could largely improve the query execution efficiency.

Please access our [research paper](http://arxiv.org/abs/2011.08724) to find more details:

```
Yu Yan, Nan Jiang, Hongzhi Wang, et al. "Multi-SQL: An extensible multi-model data query language." CoRR abs/2011.08724 (2020).arXiv:2011.08724 http://arxiv.org/abs/2011.08724.
```

## Environment

To run our parser, you need to have the systems under test installed, and JRE >=8 installed.

## Running

Users can directly use "MultiSQLPaser.java" to parse multi-model queries. And we support some test examples in "helptest.java".
