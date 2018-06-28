/* rand.x- A simple RPC Application to generate random numbers */

program RANDOM {
  version RANDOM_VERSION {
    void INITIALIZE_RANDOM ( long ) = 1;        /* service #1 */
    double GET_NEXT_RANDOM ( void ) = 2;        /* service #2 */
  } = 1;
} = 0x30000000;         /* program # */
