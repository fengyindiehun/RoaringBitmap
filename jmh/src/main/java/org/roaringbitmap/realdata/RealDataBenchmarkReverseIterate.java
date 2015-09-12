package org.roaringbitmap.realdata;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.roaringbitmap.realdata.state.BenchmarkState;
import org.roaringbitmap.realdata.wrapper.Bitmap;
import org.roaringbitmap.realdata.wrapper.BitmapIterator;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class RealDataBenchmarkReverseIterate {

   @Benchmark
   public int reverseIterate(BenchmarkState bs) {
      int total = 0;
      for (int k = 0; k < bs.bitmaps.size(); ++k) {
         Bitmap bitmap = bs.bitmaps.get(k);
         BitmapIterator i = bitmap.reverseIterator();
         while(i.hasNext()) {
            total += i.next();
         }
      }
      return total;
   }

}
