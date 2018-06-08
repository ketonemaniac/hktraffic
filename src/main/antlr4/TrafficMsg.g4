grammar TrafficMsg;

@header {
    package net.ketone.hktraffic.antlr;
}

parse :  (PUNCTUATION? sentence PUNCTUATION)* EOF;

sentence: ( areaMsg | accidentMsg | ~PUNCTUATION )+;

areaMsg:  EARLIER? area TO area;

accidentMsg: NEAR (area ANYCHAR LANE | area)? HAS ACCIDENT update?;

deadCarMsg: NEAR (area ANYCHAR LANE | area)? HAS DEADCAR update?;

update : RESOLVED ~(PUNCTUATION)* | NOTRESOLVED ~(PUNCTUATION)* ;

area : ~(PUNCTUATION)+ ;

PUNCTUATION :
'\u3002' |
'\uFF1F' |
'\uFF01' |
'\uFF0C' |
'\u3001' |
'\uFF1B' |
'\uFF1A' |
'\u300C' |
'\u300D' |
'\u300E' |
'\u300F' |
'\u2018' |
'\u2019' |
'\u201C' |
'\u201D' |
'\uFF08' |
'\uFF09' |
'\u3014' |
'\u3015' |
'\u3010' |
'\u3011' |
'\u2014' |
'\u2026' |
'\u2013' |
'\uFF0E' |
'\u300A' |
'\u300B' |
'\u3008' |
'\u3009' |
'\uFE30' ;

TO : '去';

NEAR : '近';

HAS : '的'|'有';

ACCIDENT : '交通意外';

DEADCAR : '壞車';

LANE : '線';

EARLIER : '較早前';

RESOLVED : '已經';

NOTRESOLVED : '仍未';

ANYCHAR :'$'
    |    '_'
    |    'a'..'z'
    |    '\u0080'..'\ufffe'
;

