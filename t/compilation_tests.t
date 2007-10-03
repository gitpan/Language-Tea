#!/usr/bin/perl

use strict;
use warnings;

# this test will run ./destea through all files in
# t_tea and compare the result with the file in t_java

our @files;
BEGIN {
    use File::Find::Rule;
    @files = sort grep { ! /\/\./ } File::Find::Rule->file()->not_name('*~')->in('t_tea');
};

use Test::More tests => scalar @files;
use Symbol;
use File::Slurp qw(slurp);
use IPC::Open3;

for my $file (@files) {
    my $o = $file;
    $o =~ s/^t_tea//;
    $o =~ s/\.tea$//;
    my $java = 't_java/'.$o.'.java';
    unless (-e $java) {
        fail($file);
    } else {
        my ($in,$out,$err) = (gensym(),gensym(),gensym());
        my $pid = open3($in, $out, $err, 'bin/destea', $file) || die 'Error openning compiler: '.$!;
        close $in;
        my $result = slurp $out;
        $result =~ s/\s+//g;
        $result =~ s/\n+//g;
        my $warns = slurp $err;
        chomp $warns;
        $warns =~ s/\n/\n#/gs;
        print "#".$warns."\n";
        waitpid $pid, 0;
        close $out;
        close $err;
        my $expected = slurp $java;
        $expected =~ s/\s+//g;
        $expected =~ s/\n+//g;
        is($result,$expected,$file);
    }
}

